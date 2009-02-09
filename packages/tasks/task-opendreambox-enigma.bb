DESCRIPTION = "OpenDreambox: Enigma Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

PROVIDES = "\
  task-opendreambox-ui \
  ${PACKAGES} \
"

PACKAGES = "\
  task-opendreambox-enigma \
  task-opendreambox-modem \
"

#
# task-opendreambox-enigma
#
RPROVIDES_task-opendreambox-enigma = "task-opendreambox-ui"
DESCRIPTION_task-opendreambox-enigma = "OpenDreambox: Enigma Dependencies"
DEPENDS_task-opendreambox-enigma = "\
  tuxbox-plugins \
  tuxbox-plugins-enigma \
  links-dream \
"
RDEPENDS_task-opendreambox-enigma = "\
  enigma \
  ipkgpl \
  links-dream-plugin \
  tuxbox-plugin-master \
  tuxbox-plugin-mines  \
  tuxbox-plugin-pacman \
  tuxbox-plugin-snake \
  tuxbox-plugin-soko \
  tuxbox-plugin-sol \
  tuxbox-plugin-solitair \
  tuxbox-plugin-tank \
  tuxbox-plugin-tetris \
  tuxbox-plugin-tuxcom \
  tuxbox-plugin-tuxmail \
  tuxbox-plugin-tuxtxt \
  tuxbox-plugin-vierg \
  tuxbox-plugin-yahtzee \
  enigma-locale-cs enigma-locale-da \
  enigma-locale-de enigma-locale-el enigma-locale-es enigma-locale-et \
  enigma-locale-fi enigma-locale-fr enigma-locale-hr enigma-locale-hu \
  enigma-locale-is enigma-locale-it enigma-locale-lt enigma-locale-nl \
  enigma-locale-no enigma-locale-pl enigma-locale-pt enigma-locale-ro \
  enigma-locale-ru enigma-locale-sk enigma-locale-sl \
  enigma-locale-sv enigma-locale-tr \
  task-opendreambox-modem \
"

# disabled languages: enigma-locale-ar enigma-locale-sr enigma-locale-ur

RDEPENDS_task-opendreambox-enigma_append_dm7020 = "\
  enigma-plugin-dreamdata \
  tuxbox-plugin-lcdcirc \
  tuxbox-plugin-satfind \
"
 
RDEPENDS_task-opendreambox-enigma_append_dm600pvr = "\
  enigma-blindscan \
  dreambox-blindscan-utils \
"
 
RDEPENDS_task-opendreambox-enigma_append_dm500plus = "\
  enigma-blindscan \
  dreambox-blindscan-utils \
"

PACKAGE_ARCH_task-opendreambox-enigma = "${MACHINE_ARCH}"

#
# task-opendreambox-modem
#
DESCRIPTION_task-opendreambox-modem = "OpenDreambox: Modem Support"
RDEPENDS_task-opendreambox-modem = "\
  enigma-modem \
  kernel-module-crc-ccitt \
  kernel-module-ppp-async \
  kernel-module-ppp-generic \
  kernel-module-slhc \
  update-modules \
"
 
