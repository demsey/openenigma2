require gst-plugins.inc

SRC_URI += "file://gst-plugins-directfb-fix.patch;patch=1;pnum=2"
DEPENDS += "gst-plugins-base"
