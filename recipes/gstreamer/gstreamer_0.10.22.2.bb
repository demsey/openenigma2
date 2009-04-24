require gstreamer.inc

SRC_URI = "http://gstreamer.freedesktop.org/src/gstreamer/pre/gstreamer-${PV}.tar.bz2"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}
