DESCRIPTION = "zope.interface is provides Zope 3-styled interface definitions \
for python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "ZPL"
SRCNAME = "zope.interface"

SRC_URI = "http://www.zope.org/Products/ZopeInterface/${PV}/${SRCNAME}-${PV}.tar.gz"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
