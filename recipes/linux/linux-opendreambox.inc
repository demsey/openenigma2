DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"

inherit kernel

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	http://sources.dreamboxupdate.com/download/kernel-patches/${P}-${SRCREV}.patch.bz2;patch=1 \
	file://defconfig"

S = "${WORKDIR}/linux-${PV}"

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	oe_runmake oldconfig
}

do_install_append () {
	install -d ${D}/boot
	install -m 0755 vmlinux ${D}/boot/vmlinux
	echo "/flash/bootlogo.elf" > ${D}/boot/autoexec.bat
	gzip ${D}/boot/vmlinux
	echo "/flash/vmlinux.gz" >> ${D}/boot/autoexec.bat
}

pkg_preinst_kernel-image () {
	[ -d /proc/stb ] && mount -o rw,remount /boot
	true
}

pkg_postinst_kernel-image () {
	[ -d /proc/stb ] && mount -o ro,remount /boot
	true
}

pkg_prerm_kernel-image () {
	[ -d /proc/stb ] && mount -o rw,remount /boot
	true
}

pkg_postrm_kernel-image () {
	[ -d /proc/stb ] && mount -o ro,remount /boot
	true
}
