DESCRIPTION = "Hardware drivers for Dreambox"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
RDEPENDS_dm8000 = "dreambox-secondstage"
RDEPENDS_dm800 = "dreambox-secondstage"

KV_dm500hd = "2.6.30-dm500hd"
PV_dm500hd = "${KV}-20090727"

KV_dm7020 = "2.6.9"
PV_dm7020 = "${KV}-20060622"

KV_dm7025 = "2.6.30-dm7025"
PV_dm7025 = "${KV}-20090729"

KV_dm600pvr = "2.6.12"
PV_dm600pvr = "${KV}-20090430"

KV_dm500plus = "2.6.12"
PV_dm500plus = "${KV}-20080822"

KV_dm800 = "${@base_contains('PREFERRED_VERSION_linux-dm800', '2.6.18', '2.6.18-7.1-dm800', '2.6.30-dm800', d)}"
PV_dm800 = "${KV}-${@base_contains('PREFERRED_VERSION_linux-dm800', '2.6.18', '20100210', '20090723', d)}"

KV_dm8000 = "${@base_contains('PREFERRED_VERSION_linux-dm8000', '2.6.18', '2.6.18-7.1-dm8000', '2.6.30-dm8000', d)}"
PV_dm8000 = "${KV}-${@base_contains('PREFERRED_VERSION_linux-dm8000', '2.6.18', '20100119', '20090820', d)}"

RDEPENDS = "kernel (${KV})"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/snapshots/dreambox-dvb-modules-${MACHINE}-${PV}.tar.bz2 "
SRC_URI_append_dm7025 = "http://sources.dreamboxupdate.com/download/7020/fpupgrade-${MACHINE}-v7"
SRC_URI_append_dm8000 = "http://sources.dreamboxupdate.com/download/7020/fpupgrade-${MACHINE}-v5"

S = "${WORKDIR}"

do_install_powerpc() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in head; do
		install -m 0644 $f.ko ${D}/lib/modules/${KV}/extra/$f.ko;
	done
}

do_install_mipsel() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in *.ko LICENSE; do
		install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
	done
}

do_install_append_dm7025() {
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/fpupgrade-${MACHINE}-v7 ${D}${sbindir}/fpupgrade
}

do_install_append_dm8000() {
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/fpupgrade-${MACHINE}-v5 ${D}${sbindir}/fpupgrade
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
