DESCRIPTION = "Opkg Package Manager"
DESCRIPTION_libopkg = "Opkg Package Manager Library"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "curl gpgme"
PV = "0.1.6+svnr${SRCREV}"

SRC_URI = "svn://opkg.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

# We use an older version in opendreambox but the fix from r196 is important
SRC_URI_append_opendreambox = " file://r196.diff;patch=1"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
