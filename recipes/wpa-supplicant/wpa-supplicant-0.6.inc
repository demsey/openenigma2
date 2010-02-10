DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
SECTION = "network"
LICENSE = "GPL"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "dbus gnutls ${@base_contains("COMBINED_FEATURES", "madwifi", "madwifi-ng", "",d)}"
INC_PR = "r5"

DEPENDS_opendreambox = "libnl openssl"
DEPENDS_opendreambox_append_dm8000 = " ${@base_contains('PREFERRED_VERSION_linux-dm8000', '2.6.18', 'madwifi-ng', '', d)}"
TARGET_CFLAGS_append_dm8000 = " ${@base_contains('PREFERRED_VERSION_linux-dm8000', '2.6.18', ' -I${STAGING_INCDIR}/madwifi-ng', '', d)}"

#we introduce MY_ARCH to get 'armv5te' as arch instead of the misleading 'arm' on armv5te builds
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('COMBINED_FEATURES', 'madwifi', '${MACHINE_ARCH}', '${MY_ARCH}', d)}"

DEFAULT_PREFERENCE = "-2"

SRC_URI = "http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
	file://defconfig-0.6.0-gnutls \
	file://ifupdown.sh \
	file://functions.sh"

#	file://gnutlsfix.patch;patch=1 \

SRC_URI_append_dm8000 = " ${@base_contains('PREFERRED_VERSION_linux-dm8000', '2.6.18', 'file://defconfig-0.6.0-old', '', d)}"
SRC_URI_append_dm800 = " ${@base_contains('PREFERRED_VERSION_linux-dm800', '2.6.18', 'file://defconfig-0.6.0-old', '', d)}"

S = "${WORKDIR}/wpa_supplicant-${PV}/wpa_supplicant"

PACKAGES_prepend = "wpa-supplicant-passphrase "
FILES_wpa-supplicant-passphrase = "/usr/sbin/wpa_passphrase"

RREPLACES = "wpa-supplicant-cli"

RRECOMMENDS_${PN} = "wpa-supplicant-passphrase"

export HAS_MADWIFI = "${@base_contains('COMBINED_FEATURES', 'madwifi', 1, 0,d)}"
do_configure () {
        install -m 0755 ${WORKDIR}/defconfig-0.6.0-gnutls  .config

        if [ "x$HAS_MADWIFI" == "x1" ] ; then
                echo "CONFIG_DRIVER_MADWIFI=y" >> .config
                echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
        fi
}

export NEED_OLD_8K = "${@base_contains('PREFERRED_VERSION_linux-dm8000', '2.6.18', 1, 0, d)}"
do_configure_dm8000 () {
	if [ "x$NEED_OLD_8K" == "x1" ] ; then
		install -m 0755 ${WORKDIR}/defconfig-0.6.0-old .config
                echo "CONFIG_DRIVER_MADWIFI=y" >> .config
	else
		install -m 0755 ${WORKDIR}/defconfig-0.6.0-gnutls .config
	fi
}

export NEED_OLD_800 = "${@base_contains('PREFERRED_VERSION_linux-dm800', '2.6.18', 1, 0, d)}"
do_configure_dm800 () {
	if [ "x$NEED_OLD_800" == "x1" ] ; then
		install -m 0755 ${WORKDIR}/defconfig-0.6.0-old .config
	else
		install -m 0755 ${WORKDIR}/defconfig-0.6.0-gnutls .config
	fi
}

do_compile () {
	make
}

do_install () {
	install -d ${D}${sbindir}
	install -m 755 wpa_supplicant ${D}${sbindir}
	install -m 755 wpa_passphrase ${D}${sbindir}
	install -m 755 wpa_cli        ${D}${sbindir}

	install -d ${D}${localstatedir}/run/wpa_supplicant

	install -d ${D}${docdir}/wpa_supplicant
	install -m 644 README ${D}${docdir}/wpa_supplicant

	install -d ${D}${sysconfdir}/network/if-pre-up.d/
	install -d ${D}${sysconfdir}/network/if-post-down.d/
	install -d ${D}${sysconfdir}/network/if-down.d/

	install -d ${D}${sysconfdir}/wpa_supplicant
	install -m 755 ${WORKDIR}/ifupdown.sh ${D}${sysconfdir}/wpa_supplicant/
	install -m 755 ${WORKDIR}/functions.sh ${D}${sysconfdir}/wpa_supplicant

	if grep "^CONFIG_CTRL_IFACE_DBUS=y" ${WORKDIR}/defconfig-0.6.0-gnutls; then
		install -d ${D}/${sysconfdir}/dbus-1/system.d
		install -m 644 ${S}/dbus-wpa_supplicant.conf ${D}/${sysconfdir}/dbus-1/system.d
		install -d ${D}/${datadir}/dbus-1/system-services
		sed -i -e s:${base_sbindir}:${sbindir}:g ${S}/dbus-wpa_supplicant.service
		install -m 644 ${S}/dbus-wpa_supplicant.service ${D}/${datadir}/dbus-1/system-services/fi.epitest.hostap.WPASupplicant.service
	fi

	ln -s /etc/wpa_supplicant/ifupdown.sh ${D}${sysconfdir}/network/if-pre-up.d/wpasupplicant
	ln -s /etc/wpa_supplicant/ifupdown.sh ${D}${sysconfdir}/network/if-post-down.d/wpasupplicant
}

FILES_${PN} += "${datadir}/dbus-1/system-services/*"
