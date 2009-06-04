require gst-plugins.inc

PR = "r0"

do_configure_prepend() {
    sed -i -e s:docs::g Makefile.am
}

DEPENDS += "gst-plugins-base"

EXTRA_OECONF_opendreambox += "--disable-apexsink --disable-dvdnav "

RCONFLICTS_gst-plugin-mpegdemux = "gst-plugin-fluendo-mpegdemux"
RREPLACES_gst-plugin-mpegdemux = "gst-plugin-fluendo-mpegdemux"
