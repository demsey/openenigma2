DESCRIPTION = "Google Data API"
AUTHOR = "Jeffrey Scudder"
HOMEPAGE = "http://code.google.com/p/gdata-python-client/"
SECTION = "network"
PRIORITY = "optional"
LICENSE = "Apache 2.0"
PROVIDES = "python-gdata"
DEPENDS = "python-native"

inherit distutils

PR = "r0"

SRC_URI = "http://gdata-python-client.googlecode.com/files/gdata.py-${PV}.tar.gz;md5sum=8addbac38dabdc7e00701d7b60685d4d"

S = "${WORKDIR}/gdata.py-${PV}"

PACKAGES = "python-gdata"

do_stage() {
	distutils_stage_all
}
