require gst-plugins.inc
PR = "r0"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

SRC_URI += "file://v4l2src_fixformats.patch;patch=1;pnum=0"

EXTRA_OECONF += "--with-check=no "
DEPENDS += "gst-plugins-base"
