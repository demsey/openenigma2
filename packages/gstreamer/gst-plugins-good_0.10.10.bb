require gst-plugins.inc
PR = "r0"

EXTRA_OECONF += "--with-check=no"
DEPENDS += "gst-plugins-base"
