require busybox.inc
PR = "r12"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.gz \
  http://busybox.net/downloads/fixes-1.13.2/busybox-1.13.2-depmod.patch;patch=1 \
  http://busybox.net/downloads/fixes-1.13.2/busybox-1.13.2-init.patch;patch=1 \
  http://busybox.net/downloads/fixes-1.13.2/busybox-1.13.2-mdev.patch;patch=1 \
  http://busybox.net/downloads/fixes-1.13.2/busybox-1.13.2-modprobe.patch;patch=1 \
  http://busybox.net/downloads/fixes-1.13.2/busybox-1.13.2-tar.patch;patch=1 \
  \
  file://udhcpscript.patch;patch=1 \
  file://udhcpc-fix-nfsroot.patch;patch=1 \
  file://B921600.patch;patch=1 \
  file://find-touchscreen.sh \
  file://busybox-cron \
  file://busybox-httpd \
  file://busybox-udhcpd \
  file://default.script \
  file://hwclock.sh \
  file://mount.busybox \
  file://syslog \
  file://syslog.conf \
  file://umount.busybox \
  file://defconfig \
  file://mdev \
  file://mdev.conf \
"

SRC_URI_append_opendreambox = "\
  file://hdparm_M.patch;patch=1 \
  file://dhcp-hostname.patch;patch=1 \
  file://keymap_endianess.patch;patch=1 \
  file://nptl_task.patch;patch=1 \
"

EXTRA_OEMAKE += "V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX}"

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}

do_install_append() {
    install -m 0644 ${WORKDIR}/mdev.conf ${D}${sysconfdir}/
    install -d ${D}${sysconfdir}/init.d/
    install -d ${D}${sysconfdir}/mdev
    install -m 0755 ${WORKDIR}/find-touchscreen.sh ${D}${sysconfdir}/mdev/
    install -m 0755 ${WORKDIR}/mdev ${D}${sysconfdir}/init.d/
}