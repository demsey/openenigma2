require gst-plugins.inc

PR = "${INC_PR}.0"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

EXTRA_OECONF += "--with-check=no "
DEPENDS += "gst-plugins-base"
