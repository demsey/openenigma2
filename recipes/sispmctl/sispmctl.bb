DESCRIPTION = "GEMBIRD SiS-PM control utility"
AUTHOR = "Mondrian Nuessle <nuessle@uni-mannheim.de>"
HOMEPAGE = "http://sispmctl.sourceforge.net/"
LICENSE = "GPLv2"
PRIORITY = "optional"

PV = "2.7"
PR = "r0"

DEPENDS = "libusb"

SRC_URI = "http://downloads.sourceforge.net/${PN}/${PN}-${PV}.tar.gz"

FILES_${PN} = "/usr/bin "

EXTRA_OECONF = " --enable-webless"
inherit autotools
