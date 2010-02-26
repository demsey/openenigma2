DESCRIPTION = "Module for manipulating ID3 (v1 + v2) tags in Python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Dr. Best <dr.best@dreambox-tools.info>"
LICENSE = "GPL"
SRCNAME = "mutagen"

DEPENDS = "python"
RDEPENDS = "python-shell"

SRC_URI = "http://mutagen.googlecode.com/files/mutagen-${PV}.tar.gz \
	file://patch.diff;patch=1;pnum=1 \
"

S = "${WORKDIR}/mutagen-${PV}"

inherit distutils


