DESCRIPTION = "Simple Python wrapper around the OpenSSL library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "pyOpenSSL"
DEPENDS = "openssl"
RDEPENDS = "python-threading"
RDEPENDS_${PN}-tests = "${PN}"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyopenssl/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${libdir}/${PYTHON_DIR}/site-packages/OpenSSL/test"
