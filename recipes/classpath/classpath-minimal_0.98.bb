require classpath.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/${PBN}-${PV}"

SRC_URI += "\
  file://SimpleName.diff;patch=1;pnum=0 \
  file://ecj_java_dir.patch;patch=1 \
  file://autotools.patch;patch=1 \
  file://fix-gmp.patch;patch=1 \
"

PR = "r3"

PROVIDES = "${PN} classpath"

EXTRA_OECONF += "\
                --enable-local-sockets \
                --disable-alsa \
                --disable-gconf-peer \
                --disable-gtk-peer \
                --disable-plugin \
                --disable-dssi \
                --disable-examples \
               "

CPPACKAGES = "${PBN}-common ${PBN}-tools"

