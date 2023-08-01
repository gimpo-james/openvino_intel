# OpenVINO_Intel 
 It's from https://docs.openvino.ai/2023.0/openvino_docs_install_guides_installing_openvino_yocto.html#


#Create a Yocto Image with Intel® Distribution of OpenVINO™ toolkit¶

  ; This document provides instructions for creating a Yocto image with Intel® Distribution of OpenVINO™ toolkit.


#System Requirements
  ; Follow the Yocto Project official documentation to set up and configure your host machine to be compatible with BitBake.


##Step 1: Set Up Environment:  
  1. git clone repository:
       The ssh key registration is needed after making the ssh key. ( Refer to the  https://docs.github.com/ko/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent  )  
       ex)  git clone git@github.com:gimpo-james/openvino_intel.git

  2. Set up the OpenEmbedded build environment:
  
      cd code 

      source poky/oe-init-build-env

      bitbake-layers add-layer ../meta-intel

      bitbake-layers add-layer ../meta-openembedded/meta-oe

      bitbake-layers add-layer ../meta-openembedded/meta-python

      bitbake-layers add-layer ../meta-clang

	  ps.  To make sure below layers using  bitbake-layers show-layers

        |  layer                 path                                                                    priority
        | ========================================================================================================
        | core                   ~/code/poky/meta                                5
        | yocto                  ~/code/poky/meta-poky                           5
        | yoctobsp               ~/code/poky/meta-yocto-bsp                      5
        | intel                  ~/code/meta-intel                               5
        | openembedded-layer     ~/code/meta-openembedded/meta-oe                5
        | meta-python            ~/code/meta-openembedded/meta-python            5
        | clang-layer            ~/code/meta-clang                               7



		
##Step 2: Build a Yocto Image with OpenVINO Packages:
    ; Run BitBake to build your image with OpenVINO packages. For example, to build the minimal image, run the following command:

    bitbake core-image-minimal

    #Note
    #For validation/testing/reviewing purposes, you may consider using the nohup command and ensure that your vpn/ssh connection remains uninterrupted.


##Step 3: Verify the Yocto Image

    ; Verify that OpenVINO packages were built successfully. Run the following command:

    oe-pkgdata-util list-pkgs | grep openvino

    #If the image build is successful, it will return the list of packages as below:
        openvino-inference-engine
        openvino-inference-engine-dbg
        openvino-inference-engine-dev
        openvino-inference-engine-python3
        openvino-inference-engine-samples
        openvino-inference-engine-src
        openvino-model-optimizer
        openvino-model-optimizer-dbg
        openvino-model-optimizer-dev


##Additional Resources

    -.Troubleshooting Guide -https://docs.openvino.ai/2023.0/openvino_docs_get_started_guide_troubleshooting_issues.html#yocto-install-issues
    -.Yocto Project - official documentation webpage - https://docs.yoctoproject.org/
    -.BitBake Tool - https://docs.yoctoproject.org/bitbake/
    -.Poky - https://git.yoctoproject.org/poky
    -.Meta-intel - https://git.yoctoproject.org/meta-intel/tree/README
    -.Meta-openembedded - http://cgit.openembedded.org/meta-openembedded/tree/README
    -.Meta-clang - https://github.com/kraj/meta-clang/tree/master/#readme

