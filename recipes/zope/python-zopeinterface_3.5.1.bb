DESCRIPTION = "Interface definitions for Zope products"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "ZPL"

RPROVIDES_${PN} += " zope-interfaces"

inherit distutils

PR = "r1"

SRC_URI = "http://pypi.python.org/packages/source/z/zope.interface/zope.interface-${PV}.tar.gz"
S = "${WORKDIR}/zope.interface-${PV}"

inherit setuptools

PACKAGES =+ "${PN}-tests"

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"
FILES_${PN}-dev += "${libdir}/${PYTHON_DIR}/site-packages/zope/interface/*.c"
FILES_${PN}-doc += "${libdir}/${PYTHON_DIR}/site-packages/zope/interface/*.txt"
FILES_${PN}-tests = " \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/tests \
	${libdir}/${PYTHON_DIR}/site-packages/zope/interface/common/tests \
"
