require gst-plugins.inc

SRC_URI += "file://gst-plugins-directfb-fix.patch;patch=1;pnum=2 \
	file://input-selector-segment.patch;patch=1;pnum=0 \
	file://disable_doc.patch;patch=1;pnum=1"

DEPENDS += "gst-plugins-base"

EXTRA_OECONF_opendreambox += "--disable-apexsink "

