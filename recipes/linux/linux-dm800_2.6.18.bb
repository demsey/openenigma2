require linux-opendreambox.inc

SRCREV = "791f9cc7d5e91e43ad6ea42c364d7e3e7f097cbe"
PR = "r0"

SRC_URI += " http://trappist.elis.ugent.be/~mronsse/cdfs/download/cdfs-2.6.18.tar.bz2 \
	file://stblinux-2.6.18-cdfs.patch \
	file://linux-2.6.18-fix-mips-crosscompile.patch;patch=1 \
	file://linux-2.6.18-fix-proc-cputype.patch;patch=1"

do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/dm800_defconfig ${S}/.config
	if [ -d ${WORKDIR}/cdfs-${PV} ]; then
		mv ${WORKDIR}/cdfs-${PV} ${S}/fs/cdfs
		cd ${S} & patch -p1 < ${WORKDIR}/stblinux-2.6.18-cdfs.patch
	fi;
	oe_runmake oldconfig
}
