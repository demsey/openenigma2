DESCRIPTION = "OpenDreambox: CD-Player Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-cdplayer
#
DESCRIPTION_${PN} = "OpenDreambox: CD-Player Support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
 enigma2-plugin-extensions-cdinfo \
 kernel-module-cdfs \
 libcddb \
 libcdio \
"

