DESCRIPTION = "ARM Kernel Shim"
SECTION = ""
PRIORITY = "optional"
HOMEPAGE = "http://wiki.buici.com/twiki/bin/view/Main/ApexBootloader"
LICENSE = "GPL"
PR = "r4"

COMPATIBLE_MACHINE = "(ixp4xx|nslu2)"

SRC_URI = "ftp://ftp.buici.com/pub/arm/arm-kernel-shim/arm-kernel-shim-${PV}.tar.gz \
	   file://passthrough-atags.patch;patch=1 \
	   file://cmdline_if_none.patch;patch=1 \
	   file://config-nslu2.h \
	   file://config-nas100d.h \
	   file://config-dsmg600.h \
	   file://config-fsg3.h"

S = ${WORKDIR}/arm-kernel-shim-${PV}/${PV}

EXTRA_OEMAKE_append = " CROSS_COMPILE=${CROSS_DIR}/bin/${HOST_PREFIX}"

oe_runmake() {
	mv ${S}/config.h ${S}/config.h.orig
	# NSLU2
	if [ ${SITEINFO_ENDIANESS} == "be" ] ; then
		sed -e 's|//#define FORCE_BIGENDIAN|#define FORCE_BIGENDIAN|' \
			${WORKDIR}/config-nslu2.h > ${S}/config.h
	else
		sed -e 's|//#define FORCE_LITTLEENDIAN|#define FORCE_LITTLEENDIAN|' \
			${WORKDIR}/config-nslu2.h > ${S}/config.h
	fi
	rm -f ${S}/main.o
	oenote make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nslu2
	make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nslu2 || die "oe_runmake failed"
	# NAS100d
	if [ ${SITEINFO_ENDIANESS} == "be" ] ; then
		sed -e 's|//#define FORCE_BIGENDIAN|#define FORCE_BIGENDIAN|' \
			${WORKDIR}/config-nas100d.h > ${S}/config.h
	else
		sed -e 's|//#define FORCE_LITTLEENDIAN|#define FORCE_LITTLEENDIAN|' \
			${WORKDIR}/config-nas100d.h > ${S}/config.h
	fi
	rm -f ${S}/main.o
	oenote make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nas100d
	make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-nas100d || die "oe_runmake failed"
	# DSMG-600
	if [ ${SITEINFO_ENDIANESS} == "be" ] ; then
		sed -e 's|//#define FORCE_BIGENDIAN|#define FORCE_BIGENDIAN|' \
			${WORKDIR}/config-dsmg600.h > ${S}/config.h
	else
		sed -e 's|//#define FORCE_LITTLEENDIAN|#define FORCE_LITTLEENDIAN|' \
			${WORKDIR}/config-dsmg600.h > ${S}/config.h
	fi
	rm -f ${S}/main.o
	oenote make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-dsmg600
	make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-dsmg600 || die "oe_runmake failed"
	# FSG-3
	if [ ${SITEINFO_ENDIANESS} == "be" ] ; then
		sed -e 's|//#define FORCE_BIGENDIAN|#define FORCE_BIGENDIAN|' \
			${WORKDIR}/config-fsg3.h > ${S}/config.h
	else
		sed -e 's|//#define FORCE_LITTLEENDIAN|#define FORCE_LITTLEENDIAN|' \
			${WORKDIR}/config-fsg3.h > ${S}/config.h
	fi
	rm -f ${S}/main.o
	oenote make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-fsg3
	make ${PARALLEL_MAKE} CROSS_COMPILE=${CROSS_DIR}/bin/${TARGET_PREFIX} PACKAGE=arm-kernel-shim-fsg3 || die "oe_runmake failed"
	mv ${S}/config.h.orig ${S}/config.h
}

do_populate_staging() {
	install -d ${STAGING_LOADER_DIR}
	cp ${S}/arm-kernel-shim-nslu2.bin ${STAGING_LOADER_DIR}/
	cp ${S}/arm-kernel-shim-nas100d.bin ${STAGING_LOADER_DIR}/
	cp ${S}/arm-kernel-shim-dsmg600.bin ${STAGING_LOADER_DIR}/
	cp ${S}/arm-kernel-shim-fsg3.bin ${STAGING_LOADER_DIR}/
}