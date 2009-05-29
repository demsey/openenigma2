require gst-plugins.inc

SRC_URI += "file://samihack.patch;patch=1"

PROVIDES += "gst-plugins"

PR = "r2"

EXTRA_OECONF += "--with-audioresample-format=int"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "libtheora alsa-lib"
# libsm virtual/libx11 freetype gnome-vfs libxv"

