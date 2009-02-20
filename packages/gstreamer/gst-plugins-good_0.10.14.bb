require gst-plugins.inc
PR = "r0"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

LIBTOOL = "${TARGET_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"
EXTRA_OECONF += "--with-check=no "
DEPENDS += "gst-plugins-base"
