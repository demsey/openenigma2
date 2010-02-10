# cdrkit build file

LICENSE="GPLv2"
DESCRIPTION="A set of tools for CD recording"
HOMEPAGE="http://www.cdrkit.org"

PARALLEL_MAKE = ""
DEPENDS = "libcap2 bzip2"
SRC_URI="http://cdrkit.org/releases/cdrkit-${PV}.tar.gz \
	file://xconfig.patch;patch=1"

SRC_URI_append_opendreambox = " file://cdrkit-1.1.9-glibc-2.10-3.patch;patch=1"

S="${WORKDIR}/cdrkit-${PV}"
PR = "r3"

inherit cmake 

do_install() {
	oe_runmake install DESTDIR="${D}"
}
