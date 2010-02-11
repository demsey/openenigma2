DESCRIPTION = "Dreamcrypt/Firecrypt Conditional Access Daemon"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
DEPENDS = "dreambox-wdog"
RDEPENDS = "dreambox-wdog"

PV = "1.1"
PV_mipsel = "1.2"
PR = "r3"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/dccamd-${MACHINE}-${PV}"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${WORKDIR}/dccamd-${MACHINE}-${PV} ${D}/usr/bin/dccamd
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
