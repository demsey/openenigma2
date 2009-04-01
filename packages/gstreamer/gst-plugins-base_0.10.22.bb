require gst-plugins.inc

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

SRC_URI += "file://samihack.patch;patch=1"

LIBTOOL = "${TARGET_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"
EXTRA_OECONF += "--with-audioresample-format=int"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "alsa-lib"

PR = "r0"

