DESCRIPTION = "dvd+rw-tools makes it possible to burn DVD images"
LICENSE = "GPL"
SECTION = "optional"

SRC_URI = "http://fy.chalmers.se/~appro/linux/DVD+RW/tools/${PN}-${PV}.tar.gz"

inherit autotools

EXTRA_OEMAKE = "'CC=${CC}' 'CXX=${CXX}' \
		'CFLAGS=${CFLAGS} ${LDFLAGS}' 'prefix=${D}'"
