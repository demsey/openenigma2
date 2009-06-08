DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "various"
PR = "r4"

DEPENDS = "glib-2.0"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz \
	   file://autotools.patch;patch=1 \
 	   file://no_ppc_altivec.diff;patch=1;pnum=1 \
	   file://no_ppc_fpu.diff;patch=1;pnum=1 \
 	   file://fix_ppc_build_with_old_kernel.diff;patch=1;pnum=1 \
	   file://arm-vfp.patch;patch=1 \
          "

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
