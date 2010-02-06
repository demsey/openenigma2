require gst-plugins.inc

PR = "${INC_PR}.0"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "alsa-lib"

SRC_URI += "file://samihack.patch;patch=1"

EXTRA_OECONF_opendreambox += "--disable-theora --disable-pango --with-audioresample-format=int"

