require autofs.inc

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-misc-fixes.patch;patch=1 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-multi-parse-fix.patch;patch=1 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-non-replicated-ping.patch;patch=1 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-locking-fix-1.patch;patch=1 \
           file://cross.patch;patch=1 \
           file://Makefile.rules-cross.patch;patch=1 \
	   file://install.patch;patch=1 \
	   file://auto.net-sort-option-fix.patch;patch=1 \
	   file://autofs-additional-distros.patch;patch=1 \
	   file://no-bash.patch;patch=1 \
	   file://autofs-add-hotplug.patch;patch=1"

SRC_URI_append_opendreambox = " \
           file://auto.master \
           file://auto.network \
           file://autofs"

PR = "${INC_PR}"

inherit update-rc.d

INITSCRIPT_NAME = "autofs"
INITSCRIPT_PARAMS = "defaults 21 19"

# FIXME: modules/Makefile has crappy rules that don't obey LDFLAGS
CFLAGS += "${LDFLAGS}"
EXTRA_OEMAKE = "STRIP=/bin/true"
PARALLEL_MAKE = ""

do_install_append_opendreambox () {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/autofs ${D}${sysconfdir}/init.d
	install ${WORKDIR}/auto.master ${D}${sysconfdir}/auto.master
	install ${WORKDIR}/auto.network ${D}${sysconfdir}/auto.network
}
