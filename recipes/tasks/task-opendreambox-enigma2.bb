DESCRIPTION = "OpenDreambox: Enigma2 Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r5"

inherit task

PROVIDES = "\
  task-opendreambox-ui \
  ${PACKAGES} \
"

PACKAGES = "\
  task-opendreambox-enigma2 \
"

#
# task-opendreambox-enigma2
#
RPROVIDES_task-opendreambox-enigma2 = "task-opendreambox-ui"
DESCRIPTION_task-opendreambox-enigma2 = "OpenDreambox: Enigma2 Dependencies"
RDEPENDS_task-opendreambox-enigma2 = "\
  dreambox-blindscan-utils \
  enigma2 \
  enigma2-defaultservices \
  enigma2-plugin-extensions-mediascanner \
  enigma2-plugin-systemplugins-frontprocessorupgrade \
  enigma2-plugin-systemplugins-hotplug \
  enigma2-plugin-systemplugins-networkwizard \
  enigma2-plugin-systemplugins-softwaremanager \
  enigma2-plugin-systemplugins-videotune \
  enigma2-streamproxy \
  tuxbox-tuxtxt-32bpp \
"

RRECOMMENDS_task-opendreambox-enigma2 = "\
  aio-grab \
  python-crypt \
  python-netserver \
  python-twisted-core \
  python-twisted-protocols \
  python-twisted-web \
  enigma2-plugin-extensions-cutlisteditor \
  enigma2-plugin-extensions-graphmultiepg \
  enigma2-plugin-extensions-mediaplayer \
  enigma2-plugin-extensions-pictureplayer \
  enigma2-plugin-extensions-webinterface \
  enigma2-plugin-systemplugins-satfinder \
  enigma2-plugin-systemplugins-positionersetup \
  enigma2-plugin-systemplugins-skinselector \
  ${@base_contains("MACHINE_FEATURES", "wifi", "task-opendreambox-wlan", "", d)} \
  ${@base_contains("MACHINE_FEATURES", "modem", "task-opendreambox-modem", "", d)} \
"

RDEPENDS_task-opendreambox-enigma2_append_dm500hd = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-tempfancontrol \
"

RDEPENDS_task-opendreambox-enigma2_append_dm800 = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opendreambox-enigma2_append_dm8000 = "\
  enigma2-plugin-extensions-genuinedreambox \
  enigma2-plugin-systemplugins-commoninterfaceassignment \
  enigma2-plugin-systemplugins-videomode \
"

RRECOMMENDS_task-opendreambox-enigma2_append_dm8000 = "\
  task-opendreambox-cdplayer \
  task-opendreambox-dvdplayer \
  task-opendreambox-dvdburn \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
