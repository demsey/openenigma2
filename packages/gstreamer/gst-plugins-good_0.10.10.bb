require gst-plugins.inc
FILE_PR = "r0"

EXTRA_OECONF += "--with-check=no"
DEPENDS += "gst-plugins-base"
