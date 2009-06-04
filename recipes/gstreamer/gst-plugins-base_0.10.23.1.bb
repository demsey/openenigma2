require gst-plugins.inc

SRCDATE = "20090519"
REL = "0.10.23"

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${REL}.tar.bz2 \
	file://samihack.patch;patch=1 \
	file://gst-plugins-base_${REL}_to_git${SRCDATE}.patch;patch=1;pnum=0"

S = "${WORKDIR}/${PN}-${REL}" 

PROVIDES += "gst-plugins"

PR = "r0"

EXTRA_OECONF += "--with-audioresample-format=int"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "libtheora alsa-lib"
# libsm virtual/libx11 freetype gnome-vfs libxv"

