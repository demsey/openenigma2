DESCRIPTION = "2.6 Linux Development Kernel for the Motorola GSM phones A780 and E680"
SECTION = "kernel"
AUTHOR = "Harald Welte and the OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"
LICENSE = "GPL"
DEPENDS += "quilt-native"
EZX = "ezx0"
PR = "${EZX}-r1"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_rokr-e2 = "1"

inherit kernel

KERNEL_RELEASE = "2.6.20-rc2"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-ezx"

RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"
DMSRC = "http://people.openezx.org/dotmonkey/patch"

##############################################################
# source and patches
#
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.19.tar.bz2 \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.20-rc2.bz2;patch=1 \
	   ${DMSRC}/Kconfig.patch;patch=1;pnum=5 \
	   ${DMSRC}/Makefile.patch;patch=1;pnum=5 \
	   ${DMSRC}/head-xscale.S.patch;patch=1;pnum=5 \ 
	   ${DMSRC}/sumatra.c.patch;patch=1;pnum=1 \
	   ${DMSRC}/uncompress.h.patch;patch=1;pnum=5 \
           file://logo_linux_clut224.ppm \ 
           file://defconfig-${MACHINE}"

S = "${WORKDIR}/linux-2.6.19"

##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY  = "1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680|a1200|rokr-e2)'

CMDLINE_CON = "console=ttyS2,115200n8 console=tty1 noinitrd"
CMDLINE_CON_rokr-e2 = "video=pxafb:mode:240x320-8,active console=ttyS2,115200n8 console=tty1"

CMDLINE_ROOT = "root=/dev/mmcblk0p1 rootfstype=ext3 rootdelay=5"
# uncomment if you want to boot over NFS
#CMDLINE_ROOT = "root=/dev/nfs nfsroot=192.168.1.10:/export/opie-image rootdelay=5 3"
# uncomment to enable dyntick
#CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'
CMDLINE_IP = "ip=192.168.1.2:192.168.1.10:192.168.1.10:255.255.255.0:ezx:usb0:off"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG} mem=32M@0xA0000000 mem=16M@0xAC000000"
CMDLINE_rokr-e2 = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_IP} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG}"

###############################################################
# module configs specific to this kernel
#
module_autoload_pxaficp_ir = "pxaficp_ir"
module_autoload_snd-pcm-oss = "snd-pcm-oss"

do_ezxpatch() {
	#mv ${WORKDIR}/patches ${S} && cd ${S} && quilt push -av
	#rm -Rf patches .pc
	:
}

do_configure() {
	install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm

	if [ ! -e ${WORKDIR}/defconfig-${MACHINE} ]; then
		die "No default configuration for ${MACHINE} available."
	fi

	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

	if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibcgnueabi" ]; then
		echo "CONFIG_AEABI=y"                   >> ${S}/.config
		echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
	else
		echo "# CONFIG_AEABI is not set"        >> ${S}/.config
		echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
	fi

	sed -e '/CONFIG_AEABI/d' \
	    -e '/CONFIG_OABI_COMPAT=/d' \
	    -e '/CONFIG_CMDLINE=/d' \
	    -e '/CONFIG_MTD_MTDRAM_SA1100=/d' \
	    -e '/CONFIG_MTDRAM_TOTAL_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ERASE_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ABS_POS=/d' \
	    '${WORKDIR}/defconfig-${MACHINE}' >>'${S}/.config'

	yes '' | oe_runmake oldconfig
}

###############################################################
# check the kernel is below the 1024*1024 byte limit for the boot-over usb
#
do_compile_append() {
	size=`ls -l arch/${ARCH}/boot/${KERNEL_IMAGETYPE} | awk '{ print $5}'`
	if [ $size -ge 1294336 ]; then
		rm arch/${ARCH}/boot/${KERNEL_IMAGETYPE}
		echo "Size is $size"
		die "This kernel is too big for your EZX Phone. Please reduce the size of the kernel by making more of it modular."
	fi
}

###############################################################
# put into deploy directory
#
do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${MACHINE}.tgz -C ${D} lib
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install
addtask ezxpatch before do_patch after do_unpack