DESCRIPTION = "Libcap is a library for getting and setting POSIX.1e (formerly POSIX 6) draft 15 capabilities."
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "bison-native flex-native libattr"
PR = "r1"

BUILD_CFLAGS += "-I${S}/libcap/include"
CFLAGS += "-I${S}/libcap/include"
LDFLAGS =+ "-L../libcap"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/security/linux-privs/libcap2/libcap-${PV}.tar.bz2 \
	   file://0001-build-system-fixes.patch;patch=1 \
	   file://0002-pam-includes-fix.patch;patch=1 \
	"

S = "${WORKDIR}/libcap-${PV}"

FILES_${PN} = "${libdir}"
FILES_${PN}-dev = "${includedir}"

export inc_dir=${STAGING_INCDIR}

do_install() {
	install -d ${D}${includedir}/sys
	install -m 0644 libcap/include/sys/capability.h ${D}${includedir}/sys/
	install -d ${D}${libdir}
	oe_libinstall -s -C libcap libcap ${D}${libdir}
}

do_stage() {
	install -d ${STAGING_INCDIR}/sys
	install -m 0644 libcap/include/sys/capability.h ${STAGING_INCDIR}/sys/
	oe_libinstall -s -C libcap libcap ${STAGING_LIBDIR}
}
