require linux-opendreambox.inc

SRCREV = "0d7ab7486e5f6961d613945834caa45d0814394b"
PR = "r0"

SRC_URI += " http://trappist.elis.ugent.be/~mronsse/cdfs/download/cdfs-2.6.18.tar.bz2 \
	file://stblinux-2.6.18-cdfs.patch"

do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/dm8000_defconfig ${S}/.config
	if [ -d ${WORKDIR}/cdfs-${PV} ]; then
		mv ${WORKDIR}/cdfs-${PV} ${S}/fs/cdfs
		cd ${S} & patch -p1 < ${WORKDIR}/stblinux-2.6.18-cdfs.patch
	fi;
	oe_runmake oldconfig
}
