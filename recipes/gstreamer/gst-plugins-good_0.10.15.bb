require gst-plugins.inc

PR = "${INC_PR}.0"

SRC_URI += "file://backport_matroskademux_memleak_fix.patch;patch=1;pnum=1"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

EXTRA_OECONF += "--with-check=no "
DEPENDS += "gst-plugins-base"
