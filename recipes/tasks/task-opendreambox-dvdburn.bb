DESCRIPTION = "OpenDreambox: DVD-Burn Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-dvdburn
#
DESCRIPTION_${PN} = "OpenDreambox: DVD-Burning Support"
DEPENDS_${PN} = "enigma2"
RDEPENDS_${PN} = "\
  cdrkit \
  dvd+rw-tools \
  dvdauthor \
  enigma2-plugin-extensions-dvdburn \
  mjpegtools \
  projectx \
  python-imaging \
"

