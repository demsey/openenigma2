DESCRIPTION = "ushare is a UPnP media server"
LICENSE = "GPL"
HOMEPAGE = "http://ushare.geexbox.org/"
DEPENDS = "libupnp virtual/libiconv virtual/libintl"
SRC_URI = "http://ushare.geexbox.org/releases/ushare-${PV}.tar.bz2 \
	file://ushare.sh \
	file://ushare.conf \
	file://ts.patch;patch=1"
S = "${WORKDIR}/ushare-${PV}"

inherit autotools gettext update-rc.d

INITSCRIPT_NAME = "ushare"
INITSCRIPT_PARAMS = "defaults 40 20"

# the configure script is hand-crafted, it rejects some of the usual
# configure arguments
do_configure () {
	${S}/configure \
		    --prefix=${prefix} \
		    --bindir=${bindir} \
		    --localedir=${datadir}/locale \
		    --sysconfdir=${sysconfdir} \
		    --cross-compile
}

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/ushare.sh ${D}/etc/init.d/ushare
	install -m 0644 ${WORKDIR}/ushare.conf ${D}/etc/ushare.conf
}
