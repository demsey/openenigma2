DESCRIPTION = "OpenDreambox: madwifi Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-madwifi
#
DESCRIPTION_${PN} = "OpenDreambox: madwifi Support"
DEPENDS_${PN} = "\
  madwifi-ng \
"
RDEPENDS_${PN} = "\
  madwifi-ng-modules \
  madwifi-ng-tools \
"

