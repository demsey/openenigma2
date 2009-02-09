require gst-plugins.inc

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

SRC_URI += "file://gst-plugins-directfb-fix.patch;patch=1;pnum=2 \
	file://input-selector-segment.patch;patch=1;pnum=0"

DEPENDS += "gst-plugins-base"

EXTRA_OECONF_opendreambox += "--disable-apexsink "

