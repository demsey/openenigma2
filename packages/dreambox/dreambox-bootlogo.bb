DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

IMAGES_VERSION = "1"
BINARY_VERSION = "1"
BINARY_VERSION_dm7025 = "2"
BINARY_VERSION_dm800 = "2"
BINARY_VERSION_dm8000 = "2"

PV = "${BINARY_VERSION}.${IMAGES_VERSION}"
PR = "r1"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/bootlogo-${MACHINE}-${BINARY_VERSION}.elf \
	http://sources.dreamboxupdate.com/download/7020/bootlogo-${MACHINE}-${IMAGES_VERSION}.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_wait-${MACHINE}-${IMAGES_VERSION}.mvi \
	http://sources.dreamboxupdate.com/download/7020/backdrop-${MACHINE}-${IMAGES_VERSION}.mvi"

SRC_URI_append_dm8000 = " http://sources.dreamboxupdate.com/download/7020/bootlogo-${MACHINE}-${IMAGES_VERSION}.jpg"

SRC_URI_append_dm800 = " http://sources.dreamboxupdate.com/download/7020/bootlogo_${MACHINE}-${IMAGES_VERSION}.jpg \
	http://sources.dreamboxupdate.com/download/7020/switchoff_${MACHINE}-${IMAGES_VERSION}.mvi"

S = "${WORKDIR}/"

do_install() {
	install -d ${D}/boot
	install -m 0755 ${S}/bootlogo-${MACHINE}-${BINARY_VERSION}.elf ${D}/boot/bootlogo.elf
	install -m 0755 ${S}/bootlogo-${MACHINE}-${IMAGES_VERSION}.mvi ${D}/boot/bootlogo.mvi
	install -m 0755 ${S}/bootlogo_wait-${MACHINE}-${IMAGES_VERSION}.mvi ${D}/boot/bootlogo_wait.mvi
	install -m 0755 ${S}/backdrop-${MACHINE}-${IMAGES_VERSION}.mvi ${D}/boot/backdrop.mvi
}

do_install_append_dm800() {
	install -m 0755 ${S}/bootlogo-${MACHINE}-${IMAGES_VERSION}.jpg ${D}/boot/bootlogo.jpg
	install -d ${D}/usr/share/
	install -m 0755 ${S}/switchoff-${MACHINE}-${IMAGES_VERSION}.mvi ${D}/usr/share/switchoff.mvi
}

do_install_append_dm8000() {
	install -m 0755 ${S}/bootlogo-${MACHINE}-${IMAGES_VERSION}.jpg ${D}/boot/bootlogo.jpg
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot /usr/share"
