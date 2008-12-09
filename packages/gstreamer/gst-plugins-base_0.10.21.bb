require gst-plugins.inc

SRC_URI += " file://disable_doc.patch;patch=1;pnum=1 \
	file://samihack.patch;patch=1"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "alsa-lib"

PR = "r0"

