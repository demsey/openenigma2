DESCRIPTION = "Dreamcrypt/Firecrypt Conditional Access Daemon"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.1"
PV_dm7025 = "1.2"
PV_dm800 = "1.2"
PV_dm8000 = "1.2"
PR = "r3"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/dccamd-${MACHINE}-${PV} \
	    http://sources.dreamboxupdate.com/download/7020/wdog-${MACHINE} \
"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${WORKDIR}/dccamd-${MACHINE}-${PV} ${D}/usr/bin/dccamd
	install -m 0755 ${WORKDIR}/wdog-${MACHINE} ${D}/usr/bin/wdog
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
