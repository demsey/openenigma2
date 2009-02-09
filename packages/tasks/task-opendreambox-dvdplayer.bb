DESCRIPTION = "OpenDreambox: DVD-Player Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-dvdplayer
#
DESCRIPTION_${PN} = "OpenDreambox: DVD-Player Support"
DEPENDS_${PN} = "enigma2
RDEPENDS_${PN} = "\
  enigma2-plugin-extensions-dvdplayer \
"

