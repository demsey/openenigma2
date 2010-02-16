DESCRIPTION = "OpenDreambox: Modem task for the OpenDreambox distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-modem
#
DESCRIPTION_${PN} = "OpenDreambox: Modem support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
  dreambox-modem-ppp-scripts \
  enigma2-plugin-extensions-modem \
  kernel-module-ppp-async \
  kernel-module-ppp-deflate \
  kernel-module-ppp-generic \
  ppp \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
