The project's source code can be direct to here: 

https://github.com/Chufeng-Jiang/SpringBoot_DubaiShop_E-Commerce/tree/main/04-Project%20Source%20Code/DuShopProject

Project code structure：

├─  pom.xml
│  SQL Queries.txt
│
├─.idea
│  │  $PROJECT_FILE$
│  │  .gitignore
│  │  compiler.xml
│  │  dataSources.xml
│  │  encodings.xml
│  │  intellij-javadocs-4.0.1.xml
│  │  jarRepositories.xml
│  │  jpa-buddy.xml
│  │  misc.xml
│  │  qaplug_profiles.xml
│  │  uiDesigner.xml
│  │  vcs.xml
│  │
│  ├─inspectionProfiles
│  │      Project_Default.xml
│  │
│  └─libraries
│          maven_wrapper.xml
│
├─DuShopCommon
│  │  .gitignore
│  │  mvnw
│  │  mvnw.cmd
│  │  pom.xml
│  │
│  ├─.mvn
│  │  └─wrapper
│  │          maven-wrapper.jar
│  │          maven-wrapper.properties
│  │
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─dushop
│          │          └─common
│          │              ├─entity
│          │              │  │  AbstractAddress.java
│          │              │  │  AbstractAddressWithCountry.java
│          │              │  │  Address.java
│          │              │  │  AuthenticationType.java
│          │              │  │  Brand.java
│          │              │  │  CartItem.java
│          │              │  │  Category.java
│          │              │  │  CategoryNotFoundException.java
│          │              │  │  Country.java
│          │              │  │  Currency.java
│          │              │  │  Customer.java
│          │              │  │  CustomerNotFoundException.java
│          │              │  │  IdBasedEntity.java
│          │              │  │  Order.java
│          │              │  │  OrderDetail.java
│          │              │  │  OrderNotFoundException.java
│          │              │  │  OrderStatus.java
│          │              │  │  OrderTrack.java
│          │              │  │  PaymentMethod.java
│          │              │  │  Product.java
│          │              │  │  ProductDetail.java
│          │              │  │  ProductImage.java
│          │              │  │  ProductNotFoundException.java
│          │              │  │  Role.java
│          │              │  │  Setting.java
│          │              │  │  SettingBag.java
│          │              │  │  SettingCategory.java
│          │              │  │  ShippingRate.java
│          │              │  │  State.java
│          │              │  │  StateDTO.java
│          │              │  │  User.java
│          │              │  │
│          │              │  ├─order
│          │              │  │      Order.java
│          │              │  │      OrderDetail.java
│          │              │  │      OrderStatus.java
│          │              │  │      OrderTrack.java
│          │              │  │      PaymentMethod.java
│          │              │  │
│          │              │  ├─product
│          │              │  │      Product.java
│          │              │  │      ProductDetail.java
│          │              │  │      ProductImage.java
│          │              │  │
│          │              │  └─setting
│          │              │          Setting.java
│          │              │          SettingBag.java
│          │              │          SettingCategory.java
│          │              │
│          │              └─exception
│          │                      CategoryNotFoundException.java
│          │                      CustomerNotFoundException.java
│          │                      ProductNotFoundException.java
│          │
│          └─resources
│                  application.properties
│                  rebel.xml
│
└─DuShopWebParent
    │  .gitignore
    │  mvnw
    │  mvnw.cmd
    │  pom.xml
    │
    ├─.mvn
    │  └─wrapper
    │          maven-wrapper.jar
    │          maven-wrapper.properties
    │
    ├─brand-logos
    │
    ├─category-images
    │  ├─1
    │  │      electronics.png
    │
    ├─DuShopBackEnd
    │  │  .gitignore
    │  │  mvnw
    │  │  mvnw.cmd
    │  │  pom.xml
    │  │  user-photo-InteliJ Idea-Configuration.png
    │  │
    │  ├─.mvn
    │  │  └─wrapper
    │  │          maven-wrapper.jar
    │  │          maven-wrapper.properties
    │  │
    │  ├─src
    │  │  ├─main
    │  │  │  ├─000
    │  │  │  │  ├─java
    │  │  │  │  │  └─com
    │  │  │  │  │      └─dushop
    │  │  │  │  │          └─admin
    │  │  │  │  │              │  AbstractExporter.java
    │  │  │  │  │              │  DuShopBackEndApplication.java
    │  │  │  │  │              │  FileUploadUtil.java
    │  │  │  │  │              │  MainController.java
    │  │  │  │  │              │  MvcConfig.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─brand
    │  │  │  │  │              │      BrandController.java
    │  │  │  │  │              │      BrandNotFoundException.java
    │  │  │  │  │              │      BrandNotFoundRestException.java
    │  │  │  │  │              │      BrandRepository.java
    │  │  │  │  │              │      BrandRestController.java
    │  │  │  │  │              │      BrandService.java
    │  │  │  │  │              │      CategoryDTO.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─category
    │  │  │  │  │              │      CategoryController.java
    │  │  │  │  │              │      CategoryCsvExporter.java
    │  │  │  │  │              │      CategoryPageInfo.java
    │  │  │  │  │              │      CategoryRepository.java
    │  │  │  │  │              │      CategoryRestController.java
    │  │  │  │  │              │      CategoryService.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─customer
    │  │  │  │  │              │      CustomerController.java
    │  │  │  │  │              │      CustomerRepository.java
    │  │  │  │  │              │      CustomerRestController.java
    │  │  │  │  │              │      CustomerService.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─order
    │  │  │  │  │              │      OrderController.java
    │  │  │  │  │              │      OrderNotFoundException.java
    │  │  │  │  │              │      OrderRepository.java
    │  │  │  │  │              │      OrderService.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─paging
    │  │  │  │  │              │      PagingAndSortingArgumentResolver.java
    │  │  │  │  │              │      PagingAndSortingHelper.java
    │  │  │  │  │              │      PagingAndSortingParam.java
    │  │  │  │  │              │      SearchRepository.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─product
    │  │  │  │  │              │      ProductController.java
    │  │  │  │  │              │      ProductRepository.java
    │  │  │  │  │              │      ProductRestController.java
    │  │  │  │  │              │      ProductSaveHelper.java
    │  │  │  │  │              │      ProductService.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─security
    │  │  │  │  │              │      DuShopUserDetails.java
    │  │  │  │  │              │      DuShopUserDetailsService.java
    │  │  │  │  │              │      WebSecurityConfig.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─setting
    │  │  │  │  │              │  │  CurrencyRepository.java
    │  │  │  │  │              │  │  GeneralSettingBag.java
    │  │  │  │  │              │  │  SettingController.java
    │  │  │  │  │              │  │  SettingRepository.java
    │  │  │  │  │              │  │  SettingService.java
    │  │  │  │  │              │  │
    │  │  │  │  │              │  ├─country
    │  │  │  │  │              │  │      CountryRepository.java
    │  │  │  │  │              │  │      CountryRestController.java
    │  │  │  │  │              │  │
    │  │  │  │  │              │  └─state
    │  │  │  │  │              │          StateRepository.java
    │  │  │  │  │              │          StateRestController.java
    │  │  │  │  │              │
    │  │  │  │  │              ├─shippingrate
    │  │  │  │  │              │      ShippingRateAlreadyExistsException.java
    │  │  │  │  │              │      ShippingRateController.java
    │  │  │  │  │              │      ShippingRateNotFoundException.java
    │  │  │  │  │              │      ShippingRateRepository.java
    │  │  │  │  │              │      ShippingRateService.java
    │  │  │  │  │              │
    │  │  │  │  │              └─user
    │  │  │  │  │                  │  RoleRepository.java
    │  │  │  │  │                  │  UserNotFoundException.java
    │  │  │  │  │                  │  UserRepository.java
    │  │  │  │  │                  │  UserService.java
    │  │  │  │  │                  │
    │  │  │  │  │                  ├─controller
    │  │  │  │  │                  │      AccountController.java
    │  │  │  │  │                  │      UserController.java
    │  │  │  │  │                  │      UserRestController.java
    │  │  │  │  │                  │
    │  │  │  │  │                  └─export
    │  │  │  │  │                          UserCsvExporter.java
    │  │  │  │  │                          UserExcelExporter.java
    │  │  │  │  │                          UserPdfExporter.java
    │  │  │  │  │
    │  │  │  │  └─resources
    │  │  │  │      │  application.properties
    │  │  │  │      │
    │  │  │  │      ├─static
    │  │  │  │      │  │  style.css
    │  │  │  │      │  │
    │  │  │  │      │  ├─fontawesome
    │  │  │  │      │  │      all.css
    │  │  │  │      │  │
    │  │  │  │      │  ├─images
    │  │  │  │      │  │      01.png
    │  │  │  │      │  │      default-user.png
    │  │  │  │      │  │      DuShopAdminBig.png
    │  │  │  │      │  │      DuShopAdminSmall.png
    │  │  │  │      │  │      image-thumbnail.png
    │  │  │  │      │  │
    │  │  │  │      │  ├─js
    │  │  │  │      │  │      common.js
    │  │  │  │      │  │      common_form.js
    │  │  │  │      │  │      common_form_country_state.js
    │  │  │  │      │  │      common_list.js
    │  │  │  │      │  │      countries_setting.js
    │  │  │  │      │  │      product_form.js
    │  │  │  │      │  │      product_form_details.js
    │  │  │  │      │  │      product_form_images.js
    │  │  │  │      │  │      product_form_overview.js
    │  │  │  │      │  │      states_setting.js
    │  │  │  │      │  │
    │  │  │  │      │  ├─richtext
    │  │  │  │      │  │      jquery.richtext.js
    │  │  │  │      │  │      jquery.richtext.min.js
    │  │  │  │      │  │      richtext.min.css
    │  │  │  │      │  │      richtext.scss
    │  │  │  │      │  │
    │  │  │  │      │  └─webfonts
    │  │  │  │      │          fa-brands-400.eot
    │  │  │  │      │
    │  │  │  │      └─templates
    │  │  │  │          │  error.html
    │  │  │  │          │  fragments.html
    │  │  │  │          │  index.html
    │  │  │  │          │  login.html
    │  │  │  │          │  modal_fragments.html
    │  │  │  │          │  navigation.html
    │  │  │  │          │
    │  │  │  │          ├─brands
    │  │  │  │          │      brands.html
    │  │  │  │          │      brand_form.html
    │  │  │  │          │
    │  │  │  │          ├─categories
    │  │  │  │          │      categories.html
    │  │  │  │          │      category_form.html
    │  │  │  │          │
    │  │  │  │          ├─customers
    │  │  │  │          │      customers.html
    │  │  │  │          │      customer_detail_modal.html
    │  │  │  │          │      customer_form.html
    │  │  │  │          │
    │  │  │  │          ├─error
    │  │  │  │          │      403.html
    │  │  │  │          │      404.html
    │  │  │  │          │      500.html
    │  │  │  │          │
    │  │  │  │          ├─orders
    │  │  │  │          │      orders.html
    │  │  │  │          │      order_details_modal.html
    │  │  │  │          │
    │  │  │  │          ├─products
    │  │  │  │          │      products.html
    │  │  │  │          │      product_description.html
    │  │  │  │          │      product_description_read_only.html
    │  │  │  │          │      product_details.html
    │  │  │  │          │      product_details_read_only.html
    │  │  │  │          │      product_detail_modal.html
    │  │  │  │          │      product_form.html
    │  │  │  │          │      product_images.html
    │  │  │  │          │      product_images_read_only.html
    │  │  │  │          │      product_overview.html
    │  │  │  │          │      product_shipping.html
    │  │  │  │          │      product_shipping_read_only.html
    │  │  │  │          │
    │  │  │  │          ├─settings
    │  │  │  │          │  │  countries.html
    │  │  │  │          │  │  general.html
    │  │  │  │          │  │  mail_server.html
    │  │  │  │          │  │  settings.html
    │  │  │  │          │  │  states.html
    │  │  │  │          │  │
    │  │  │  │          │  └─mail_templates
    │  │  │  │          │          customer_verification.html
    │  │  │  │          │          mail_templates.html
    │  │  │  │          │
    │  │  │  │          ├─shipping_rates
    │  │  │  │          │      shipping_rates.html
    │  │  │  │          │      shipping_rates_fragment.html
    │  │  │  │          │      shipping_rate_form.html
    │  │  │  │          │
    │  │  │  │          └─users
    │  │  │  │                  account_form.html
    │  │  │  │                  users.html
    │  │  │  │                  user_form.html
    │  │  │  │
    │  │  │  ├─java
    │  │  │  │  └─com
    │  │  │  │      └─dushop
    │  │  │  │          └─admin
    │  │  │  │              │  AbstractExporter.java
    │  │  │  │              │  BrandController.java
    │  │  │  │              │  BrandNotFoundException.java
    │  │  │  │              │  BrandNotFoundRestException.java
    │  │  │  │              │  BrandRepository.java
    │  │  │  │              │  BrandRestController.java
    │  │  │  │              │  BrandService.java
    │  │  │  │              │  CategoryController.java
    │  │  │  │              │  CategoryCsvExporter.java
    │  │  │  │              │  CategoryDTO.java
    │  │  │  │              │  CategoryPageInfo.java
    │  │  │  │              │  CategoryRepository.java
    │  │  │  │              │  CategoryRestController.java
    │  │  │  │              │  CategoryService.java
    │  │  │  │              │  CustomerController.java
    │  │  │  │              │  CustomerRepository.java
    │  │  │  │              │  CustomerRestController.java
    │  │  │  │              │  CustomerService.java
    │  │  │  │              │  DuShopBackEndApplication.java
    │  │  │  │              │  DuShopUserDetails.java
    │  │  │  │              │  DuShopUserDetailsService.java
    │  │  │  │              │  FileUploadUtil.java
    │  │  │  │              │  MainController.java
    │  │  │  │              │  MvcConfig.java
    │  │  │  │              │  OrderController.java
    │  │  │  │              │  OrderDetailRepository.java
    │  │  │  │              │  OrderRepository.java
    │  │  │  │              │  OrderRestController.java
    │  │  │  │              │  OrderService.java
    │  │  │  │              │  PagingAndSortingArgumentResolver.java
    │  │  │  │              │  PagingAndSortingHelper.java
    │  │  │  │              │  PagingAndSortingParam.java
    │  │  │  │              │  ProductController.java
    │  │  │  │              │  ProductDTO.java
    │  │  │  │              │  ProductRepository.java
    │  │  │  │              │  ProductRestController.java
    │  │  │  │              │  ProductSaveHelper.java
    │  │  │  │              │  ProductSearchController.java
    │  │  │  │              │  ProductService.java
    │  │  │  │              │  SearchRepository.java
    │  │  │  │              │  ShippingRateAlreadyExistsException.java
    │  │  │  │              │  ShippingRateController.java
    │  │  │  │              │  ShippingRateNotFoundException.java
    │  │  │  │              │  ShippingRateRepository.java
    │  │  │  │              │  ShippingRateRestController.java
    │  │  │  │              │  ShippingRateService.java
    │  │  │  │              │  WebSecurityConfig.java
    │  │  │  │              │
    │  │  │  │              ├─brand
    │  │  │  │              │      BrandController.java
    │  │  │  │              │      BrandNotFoundException.java
    │  │  │  │              │      BrandNotFoundRestException.java
    │  │  │  │              │      BrandRepository.java
    │  │  │  │              │      BrandRestController.java
    │  │  │  │              │      BrandService.java
    │  │  │  │              │      CategoryDTO.java
    │  │  │  │              │
    │  │  │  │              ├─category
    │  │  │  │              │      CategoryController.java
    │  │  │  │              │      CategoryCsvExporter.java
    │  │  │  │              │      CategoryNotFoundException.java
    │  │  │  │              │      CategoryPageInfo.java
    │  │  │  │              │      CategoryRepository.java
    │  │  │  │              │      CategoryRestController.java
    │  │  │  │              │      CategoryService.java
    │  │  │  │              │
    │  │  │  │              ├─customer
    │  │  │  │              │      CustomerController.java
    │  │  │  │              │      CustomerRepository.java
    │  │  │  │              │      CustomerRestController.java
    │  │  │  │              │      CustomerService.java
    │  │  │  │              │
    │  │  │  │              ├─order
    │  │  │  │              │      OrderController.java
    │  │  │  │              │      OrderNotFoundException.java
    │  │  │  │              │      OrderRepository.java
    │  │  │  │              │      OrderService.java
    │  │  │  │              │
    │  │  │  │              ├─paging
    │  │  │  │              │      PagingAndSortingArgumentResolver.java
    │  │  │  │              │      PagingAndSortingHelper.java
    │  │  │  │              │      PagingAndSortingParam.java
    │  │  │  │              │      SearchRepository.java
    │  │  │  │              │
    │  │  │  │              ├─product
    │  │  │  │              │      ProductController.java
    │  │  │  │              │      ProductNotFoundException.java
    │  │  │  │              │      ProductRepository.java
    │  │  │  │              │      ProductRestController.java
    │  │  │  │              │      ProductSaveHelper.java
    │  │  │  │              │      ProductService.java
    │  │  │  │              │
    │  │  │  │              ├─security
    │  │  │  │              │      DuShopUserDetails.java
    │  │  │  │              │      DuShopUserDetailsService.java
    │  │  │  │              │      WebSecurityConfig.java
    │  │  │  │              │
    │  │  │  │              ├─setting
    │  │  │  │              │  │  CurrencyRepository.java
    │  │  │  │              │  │  GeneralSettingBag.java
    │  │  │  │              │  │  SettingController.java
    │  │  │  │              │  │  SettingRepository.java
    │  │  │  │              │  │  SettingService.java
    │  │  │  │              │  │
    │  │  │  │              │  ├─country
    │  │  │  │              │  │      CountryRepository.java
    │  │  │  │              │  │      CountryRestController.java
    │  │  │  │              │  │
    │  │  │  │              │  └─state
    │  │  │  │              │          StateRepository.java
    │  │  │  │              │          StateRestController.java
    │  │  │  │              │
    │  │  │  │              ├─shippingrate
    │  │  │  │              │      ShippingRateAlreadyExistsException.java
    │  │  │  │              │      ShippingRateController.java
    │  │  │  │              │      ShippingRateNotFoundException.java
    │  │  │  │              │      ShippingRateRepository.java
    │  │  │  │              │      ShippingRateService.java
    │  │  │  │              │
    │  │  │  │              └─user
    │  │  │  │                  │  AbstractExporter.java
    │  │  │  │                  │  AccountController.java
    │  │  │  │                  │  RoleRepository.java
    │  │  │  │                  │  UserController.java
    │  │  │  │                  │  UserCsvExporter.java
    │  │  │  │                  │  UserExcelExporter.java
    │  │  │  │                  │  UserNotFoundException.java
    │  │  │  │                  │  UserPdfExporter.java
    │  │  │  │                  │  UserRepository.java
    │  │  │  │                  │  UserRestController.java
    │  │  │  │                  │  UserService.java
    │  │  │  │                  │
    │  │  │  │                  ├─controller
    │  │  │  │                  │      AccountController.java
    │  │  │  │                  │      UserController.java
    │  │  │  │                  │      UserRestController.java
    │  │  │  │                  │
    │  │  │  │                  └─export
    │  │  │  │                          AbstractExporter.java
    │  │  │  │                          UserCsvExporter.java
    │  │  │  │                          UserExcelExporter.java
    │  │  │  │                          UserPdfExporter.java
    │  │  │  │
    │  │  │  └─resources
    │  │  │      │  application.properties
    │  │  │      │  rebel.xml
    │  │  │      │
    │  │  │      ├─static
    │  │  │      │  │  style.css
    │  │  │      │  │
    │  │  │      │  ├─fontawesome
    │  │  │      │  │      all.css
    │  │  │      │  │
    │  │  │      │  ├─images
    │  │  │      │  │      01.png
    │  │  │      │  │      default-user.png
    │  │  │      │  │      DuShopAdminBig.png
    │  │  │      │  │      DuShopAdminSmall - 副本.png
    │  │  │      │  │      DuShopAdminSmall.png
    │  │  │      │  │      image-thumbnail.png
    │  │  │      │  │
    │  │  │      │  ├─js
    │  │  │      │  │      common.js
    │  │  │      │  │      common_form.js
    │  │  │      │  │      common_form_country_state.js
    │  │  │      │  │      common_from.js
    │  │  │      │  │      common_list.js
    │  │  │      │  │      countries_setting.js
    │  │  │      │  │      jquery.number.min.js
    │  │  │      │  │      orders_shipper.js
    │  │  │      │  │      order_form_add_product.js
    │  │  │      │  │      order_form_overview_products.js
    │  │  │      │  │      order_form_remove_product.js
    │  │  │      │  │      order_form_tracks.js
    │  │  │      │  │      product_form.js
    │  │  │      │  │      product_form_details.js
    │  │  │      │  │      product_form_images.js
    │  │  │      │  │      product_form_overview.js
    │  │  │      │  │      states_setting.js
    │  │  │      │  │
    │  │  │      │  ├─richtext
    │  │  │      │  │      jquery.richtext.js
    │  │  │      │  │      jquery.richtext.min.js
    │  │  │      │  │      richtext.min.css
    │  │  │      │  │      richtext.scss
    │  │  │      │  │
    │  │  │      │  └─webfonts
    │  │  │      │
    │  │  │      └─templates
    │  │  │          │  account_form.html
    │  │  │          │  error.html
    │  │  │          │  fragments.html
    │  │  │          │  index.html
    │  │  │          │  login.html
    │  │  │          │  modal_fragments.html
    │  │  │          │  navigation.html
    │  │  │          │  users.html
    │  │  │          │  user_form.html
    │  │  │          │
    │  │  │          ├─20220827
    │  │  │          │  │  error.html
    │  │  │          │  │  fragments.html
    │  │  │          │  │  index.html
    │  │  │          │  │  login.html
    │  │  │          │  │  modal_fragments.html
    │  │  │          │  │  navigation.html
    │  │  │          │  │
    │  │  │          │  ├─brands
    │  │  │          │  │      brands.html
    │  │  │          │  │      brand_form.html
    │  │  │          │  │
    │  │  │          │  ├─categories
    │  │  │          │  │      categories.html
    │  │  │          │  │      category_form.html
    │  │  │          │  │
    │  │  │          │  ├─customers
    │  │  │          │  │      customers.html
    │  │  │          │  │      customer_detail_modal.html
    │  │  │          │  │      customer_form.html
    │  │  │          │  │
    │  │  │          │  ├─error
    │  │  │          │  │      403.html
    │  │  │          │  │      404.html
    │  │  │          │  │      500.html
    │  │  │          │  │
    │  │  │          │  ├─orders
    │  │  │          │  │      orders.html
    │  │  │          │  │      order_details_modal.html
    │  │  │          │  │
    │  │  │          │  ├─products
    │  │  │          │  │      products.html
    │  │  │          │  │      product_description.html
    │  │  │          │  │      product_description_read_only.html
    │  │  │          │  │      product_details.html
    │  │  │          │  │      product_details_read_only.html
    │  │  │          │  │      product_detail_modal.html
    │  │  │          │  │      product_form.html
    │  │  │          │  │      product_images.html
    │  │  │          │  │      product_images_read_only.html
    │  │  │          │  │      product_overview.html
    │  │  │          │  │      product_shipping.html
    │  │  │          │  │      product_shipping_read_only.html
    │  │  │          │  │
    │  │  │          │  ├─settings
    │  │  │          │  │  │  countries.html
    │  │  │          │  │  │  general.html
    │  │  │          │  │  │  mail_server.html
    │  │  │          │  │  │  settings.html
    │  │  │          │  │  │  states.html
    │  │  │          │  │  │
    │  │  │          │  │  └─mail_templates
    │  │  │          │  │          customer_verification.html
    │  │  │          │  │          mail_templates.html
    │  │  │          │  │
    │  │  │          │  ├─shipping_rates
    │  │  │          │  │      shipping_rates.html
    │  │  │          │  │      shipping_rates_fragment.html
    │  │  │          │  │      shipping_rate_form.html
    │  │  │          │  │
    │  │  │          │  └─users
    │  │  │          │          account_form.html
    │  │  │          │          users.html
    │  │  │          │          user_form.html
    │  │  │          │
    │  │  │          ├─brands
    │  │  │          │      brands.html
    │  │  │          │      brand_form.html
    │  │  │          │
    │  │  │          ├─categories
    │  │  │          │      categories.html
    │  │  │          │      category_form.html
    │  │  │          │
    │  │  │          ├─customers
    │  │  │          │      customers.html
    │  │  │          │      customer_detail_modal.html
    │  │  │          │      customer_form.html
    │  │  │          │
    │  │  │          ├─error
    │  │  │          │      403.html
    │  │  │          │      404.html
    │  │  │          │      500.html
    │  │  │          │      error.html
    │  │  │          │
    │  │  │          ├─orders
    │  │  │          │      add_product_modal.html
    │  │  │          │      orders.html
    │  │  │          │      orders_shipper.html
    │  │  │          │      order_details_modal.html
    │  │  │          │      order_form.html
    │  │  │          │      order_form_overview.html
    │  │  │          │      order_form_products.html
    │  │  │          │      order_form_shipping.html
    │  │  │          │      order_form_tracks.html
    │  │  │          │      order_status_fragment.html
    │  │  │          │      search_product.html
    │  │  │          │
    │  │  │          ├─products
    │  │  │          │      products.html
    │  │  │          │      product_description.html
    │  │  │          │      product_description_read_only.html
    │  │  │          │      product_details.html
    │  │  │          │      product_details_read_only.html
    │  │  │          │      product_detail_modal.html
    │  │  │          │      product_form.html
    │  │  │          │      product_images.html
    │  │  │          │      product_images_read_only.html
    │  │  │          │      product_overview.html
    │  │  │          │      product_shipping.html
    │  │  │          │      product_shipping_read_only.html
    │  │  │          │
    │  │  │          ├─settings
    │  │  │          │  │  countries.html
    │  │  │          │  │  general.html
    │  │  │          │  │  mail_server.html
    │  │  │          │  │  payment.html
    │  │  │          │  │  settings.html
    │  │  │          │  │  states.html
    │  │  │          │  │
    │  │  │          │  └─mail_templates
    │  │  │          │          customer_verification.html
    │  │  │          │          mail_templates.html
    │  │  │          │          order_confirmation.html
    │  │  │          │
    │  │  │          ├─shipping_rates
    │  │  │          │      shipping_rates.html
    │  │  │          │      shipping_rates_fragment.html
    │  │  │          │      shipping_rate_form.html
    │  │  │          │
    │  │  │          └─users
    │  │  │                  account_form.html
    │  │  │                  users.html
    │  │  │                  user_form.html
    │  │  │
    │  │  └─test
    │  │      └─java
    │  │          └─com
    │  │              └─dushop
    │  │                  └─admin
    │  │                      ├─brand
    │  │                      │      BrandRepositoryTests.java
    │  │                      │      BrandServiceTests.java
    │  │                      │
    │  │                      ├─category
    │  │                      │      CategoryRepositoryTests.java
    │  │                      │      CategoryServiceTests.java
    │  │                      │
    │  │                      ├─order
    │  │                      │      OrderRepositoryTests.java
    │  │                      │
    │  │                      ├─product
    │  │                      │      ProductRepositoryTests.java
    │  │                      │
    │  │                      ├─setting
    │  │                      │  │  CurrencyRepositoryTests.java
    │  │                      │  │  SettingRepositoryTests.java
    │  │                      │  │
    │  │                      │  ├─country
    │  │                      │  │      CountryRepositoryTests.java
    │  │                      │  │      CountryRestControllerTests.java
    │  │                      │  │
    │  │                      │  └─state
    │  │                      │          StateRepositoryTests.java
    │  │                      │          StateRestControllerTests.java
    │  │                      │
    │  │                      ├─shippingrate
    │  │                      │      ShippingRateRepositoryTests.java
    │  │                      │
    │  │                      └─user
    │  │                          │  PasswordEncoderTest.java
    │  │                          │  RoleRepositoryTests.java
    │  │                          │  UserRepositoryTests.java
    │  │                          │
    │  │                          └─category
    │  │                                  CategoryRepositoryTests.java
    │  │                                  CategoryServiceTests.java
    │  │
    │  └─user-photos
    │
    ├─DuShopFrontEnd
    │  │  .gitignore
    │  │  mvnw
    │  │  mvnw.cmd
    │  │  pom.xml
    │  │
    │  ├─.mvn
    │  │  └─wrapper
    │  │          maven-wrapper.jar
    │  │          maven-wrapper.properties
    │  │
    │  └─src
    │      ├─main
    │      │  │  082801-F-main.zip
    │      │  │  082802-F-main.zip
    │      │  │
    │      │  ├─000
    │      │  │  ├─java
    │      │  │  │  └─com
    │      │  │  │      └─dushop
    │      │  │  │          │  DuShopFrontEndApplication.java
    │      │  │  │          │  MainController.java
    │      │  │  │          │  MvcConfig.java
    │      │  │  │          │  Utility.java
    │      │  │  │          │
    │      │  │  │          ├─address
    │      │  │  │          │      AddressController.java
    │      │  │  │          │      AddressRepository.java
    │      │  │  │          │      AddressService.java
    │      │  │  │          │
    │      │  │  │          ├─category
    │      │  │  │          │      CategoryRepository.java
    │      │  │  │          │      CategoryService.java
    │      │  │  │          │
    │      │  │  │          ├─customer
    │      │  │  │          │      CustomerController.java
    │      │  │  │          │      CustomerRepository.java
    │      │  │  │          │      CustomerRestController.java
    │      │  │  │          │      CustomerService.java
    │      │  │  │          │      ForgotPasswordController.java
    │      │  │  │          │
    │      │  │  │          ├─product
    │      │  │  │          │      ProductController.java
    │      │  │  │          │      ProductRepository.java
    │      │  │  │          │      ProductService.java
    │      │  │  │          │
    │      │  │  │          ├─security
    │      │  │  │          │  │  CustomerUserDetails.java
    │      │  │  │          │  │  CustomerUserDetailsService.java
    │      │  │  │          │  │  DatabaseLoginSuccessHandler.java
    │      │  │  │          │  │  WebSecurityConfig.java
    │      │  │  │          │  │
    │      │  │  │          │  └─oauth
    │      │  │  │          │          CustomerOAuth2User.java
    │      │  │  │          │          CustomerOAuth2UserService.java
    │      │  │  │          │          OAuth2LoginSuccessHandler.java
    │      │  │  │          │
    │      │  │  │          ├─setting
    │      │  │  │          │      CountryRepository.java
    │      │  │  │          │      EmailSettingBag.java
    │      │  │  │          │      SettingFilter.java
    │      │  │  │          │      SettingRepository.java
    │      │  │  │          │      SettingService.java
    │      │  │  │          │      StateRepository.java
    │      │  │  │          │      StateRestController.java
    │      │  │  │          │
    │      │  │  │          ├─shipping
    │      │  │  │          │      ShippingRateRepository.java
    │      │  │  │          │      ShippingRateService.java
    │      │  │  │          │
    │      │  │  │          └─shoppingcart
    │      │  │  │                  CartItemRepository.java
    │      │  │  │                  ShoppingCartController.java
    │      │  │  │                  ShoppingCartException.java
    │      │  │  │                  ShoppingCartRestController.java
    │      │  │  │                  ShoppingCartService.java
    │      │  │  │
    │      │  │  └─resources
    │      │  │      │  application.properties
    │      │  │      │  application.yml
    │      │  │      │  rebel.xml
    │      │  │      │
    │      │  │      ├─static
    │      │  │      │  ├─fontawesome
    │      │  │      │  │      all.css
    │      │  │      │  │
    │      │  │      │  ├─images
    │      │  │      │  │      01.png
    │      │  │      │  │      default-user.png
    │      │  │      │  │      DuShopAdminBig.png
    │      │  │      │  │      DuShopAdminSmall.png
    │      │  │      │  │      image-thumbnail.png
    │      │  │      │  │
    │      │  │      │  ├─js
    │      │  │      │  │      add_to_cart.js
    │      │  │      │  │      common_customer_form.js
    │      │  │      │  │      common_modal.js
    │      │  │      │  │      jquery.number.min.js
    │      │  │      │  │      quantity_control.js
    │      │  │      │  │      shopping_cart.js
    │      │  │      │  │      style.css
    │      │  │      │  │
    │      │  │      │  └─webfonts
    │      │  │      │
    │      │  │      └─templates
    │      │  │          │  breadcrumb.html
    │      │  │          │  error.html
    │      │  │          │  fragments.html
    │      │  │          │  index.html
    │      │  │          │  login.html
    │      │  │          │  message.html
    │      │  │          │  navigation.html
    │      │  │          │
    │      │  │          ├─address_book
    │      │  │          │      addresses.html
    │      │  │          │      address_form.html
    │      │  │          │
    │      │  │          ├─cart
    │      │  │          │      quantity_control.html
    │      │  │          │      shopping_cart.html
    │      │  │          │
    │      │  │          ├─customer
    │      │  │          │      account_form.html
    │      │  │          │      forgot_password_form.html
    │      │  │          │      reset_password_form.html
    │      │  │          │
    │      │  │          ├─error
    │      │  │          │      403.html
    │      │  │          │      404.html
    │      │  │          │      500.html
    │      │  │          │
    │      │  │          ├─product
    │      │  │          │      images_carousel.html
    │      │  │          │      products_by_category.html
    │      │  │          │      product_detail.html
    │      │  │          │      product_fragment.html
    │      │  │          │      search_result.html
    │      │  │          │
    │      │  │          └─register
    │      │  │                  register_form.html
    │      │  │                  register_success.html
    │      │  │                  verify_fail.html
    │      │  │                  verify_success.html
    │      │  │
    │      │  ├─java
    │      │  │  └─com
    │      │  │      └─dushop
    │      │  │          │  AddressController.java
    │      │  │          │  AddressRepository.java
    │      │  │          │  AddressService.java
    │      │  │          │  CartItemRepository.java
    │      │  │          │  CategoryRepository.java
    │      │  │          │  CategoryService.java
    │      │  │          │  CheckoutController.java
    │      │  │          │  CheckoutInfo.java
    │      │  │          │  CheckoutService.java
    │      │  │          │  CustomerController.java
    │      │  │          │  CustomerOAuth2User.java
    │      │  │          │  CustomerOAuth2UserService.java
    │      │  │          │  CustomerRepository.java
    │      │  │          │  CustomerRestController.java
    │      │  │          │  CustomerService.java
    │      │  │          │  CustomerUserDetails.java
    │      │  │          │  CustomerUserDetailsService.java
    │      │  │          │  DatabaseLoginSuccessHandler.java
    │      │  │          │  DuShopFrontEndApplication.java
    │      │  │          │  ForgotPasswordController.java
    │      │  │          │  MainController.java
    │      │  │          │  MvcConfig.java
    │      │  │          │  OAuth2LoginSuccessHandler.java
    │      │  │          │  OrderController.java
    │      │  │          │  OrderRepository.java
    │      │  │          │  OrderRestController.java
    │      │  │          │  OrderReturnRequest.java
    │      │  │          │  OrderReturnResponse.java
    │      │  │          │  OrderService.java
    │      │  │          │  ProductController.java
    │      │  │          │  ProductRepository.java
    │      │  │          │  ProductService.java
    │      │  │          │  ShippingRateRepository.java
    │      │  │          │  ShippingRateService.java
    │      │  │          │  ShoppingCartController.java
    │      │  │          │  ShoppingCartException.java
    │      │  │          │  ShoppingCartRestController.java
    │      │  │          │  ShoppingCartService.java
    │      │  │          │  Utility.java
    │      │  │          │  WebSecurityConfig.java
    │      │  │          │
    │      │  │          ├─address
    │      │  │          │      AddressController.java
    │      │  │          │      AddressRepository.java
    │      │  │          │      AddressService.java
    │      │  │          │
    │      │  │          ├─category
    │      │  │          │      CategoryRepository.java
    │      │  │          │      CategoryService.java
    │      │  │          │
    │      │  │          ├─checkout
    │      │  │          │  │  CheckoutController.java
    │      │  │          │  │  CheckoutInfo.java
    │      │  │          │  │  CheckoutService.java
    │      │  │          │  │
    │      │  │          │  └─paypal
    │      │  │          │          PayPalApiException.java
    │      │  │          │          PayPalOrderResponse.java
    │      │  │          │          PayPalService.java
    │      │  │          │
    │      │  │          ├─customer
    │      │  │          │      CustomerController.java
    │      │  │          │      CustomerRepository.java
    │      │  │          │      CustomerRestController.java
    │      │  │          │      CustomerService.java
    │      │  │          │      ForgotPasswordController.java
    │      │  │          │
    │      │  │          ├─order
    │      │  │          │      OrderRepository.java
    │      │  │          │      OrderService.java
    │      │  │          │
    │      │  │          ├─paypal
    │      │  │          │      PayPalApiException.java
    │      │  │          │      PayPalOrderResponse.java
    │      │  │          │      PayPalService.java
    │      │  │          │
    │      │  │          ├─product
    │      │  │          │      ProductController.java
    │      │  │          │      ProductRepository.java
    │      │  │          │      ProductService.java
    │      │  │          │
    │      │  │          ├─security
    │      │  │          │  │  CustomerUserDetails.java
    │      │  │          │  │  CustomerUserDetailsService.java
    │      │  │          │  │  DatabaseLoginSuccessHandler.java
    │      │  │          │  │  WebSecurityConfig.java
    │      │  │          │  │
    │      │  │          │  └─oauth
    │      │  │          │          CustomerOAuth2User.java
    │      │  │          │          CustomerOAuth2UserService.java
    │      │  │          │          OAuth2LoginSuccessHandler.java
    │      │  │          │
    │      │  │          ├─setting
    │      │  │          │      CountryRepository.java
    │      │  │          │      CurrencyRepository.java
    │      │  │          │      CurrencySettingBag.java
    │      │  │          │      EmailSettingBag.java
    │      │  │          │      PaymentSettingBag.java
    │      │  │          │      SettingFilter.java
    │      │  │          │      SettingRepository.java
    │      │  │          │      SettingService.java
    │      │  │          │      StateRepository.java
    │      │  │          │      StateRestController.java
    │      │  │          │
    │      │  │          ├─shipping
    │      │  │          │      ShippingRateRepository.java
    │      │  │          │      ShippingRateService.java
    │      │  │          │
    │      │  │          ├─shoppingcart
    │      │  │          │      CartItemRepository.java
    │      │  │          │      ShoppingCartController.java
    │      │  │          │      ShoppingCartException.java
    │      │  │          │      ShoppingCartRestController.java
    │      │  │          │      ShoppingCartService.java
    │      │  │          │
    │      │  │          └─site
    │      │  │                  DuShopFrontEndApplication.java
    │      │  │                  MainController.java
    │      │  │
    │      │  └─resources
    │      │      │  application.properties
    │      │      │  application.yml
    │      │      │  rebel.xml
    │      │      │
    │      │      ├─static
    │      │      │  ├─fontawesome
    │      │      │  │      all.css
    │      │      │  │
    │      │      │  ├─images
    │      │      │  │      01.png
    │      │      │  │      default-user.png
    │      │      │  │      DuShopAdminBig.png
    │      │      │  │      DuShopAdminSmall.png
    │      │      │  │      image-thumbnail.png
    │      │      │  │
    │      │      │  ├─js
    │      │      │  │      add_to_cart.js
    │      │      │  │      common_customer_form.js
    │      │      │  │      common_modal.js
    │      │      │  │      jquery.number.min.js
    │      │      │  │      quantity_control.js
    │      │      │  │      return_order.js
    │      │      │  │      shopping_cart.js
    │      │      │  │      style.css
    │      │      │  │
    │      │      │  └─webfonts
    │      │      │          fa-brands-400.eot
    │      │      │          fa-brands-400.svg
    │      │      │          fa-brands-400.ttf
    │      │      │          fa-brands-400.woff
    │      │      │          fa-brands-400.woff2
    │      │      │          fa-regular-400.eot
    │      │      │          fa-regular-400.svg
    │      │      │          fa-regular-400.ttf
    │      │      │          fa-regular-400.woff
    │      │      │          fa-regular-400.woff2
    │      │      │          fa-solid-900.eot
    │      │      │          fa-solid-900.svg
    │      │      │          fa-solid-900.ttf
    │      │      │          fa-solid-900.woff
    │      │      │          fa-solid-900.woff2
    │      │      │
    │      │      └─templates
    │      │          │  breadcrumb.html
    │      │          │  error.html
    │      │          │  fragments.html
    │      │          │  index.html
    │      │          │  login.html
    │      │          │  message.html
    │      │          │  navigation.html
    │      │          │  products_by_category.html
    │      │          │
    │      │          ├─20220827
    │      │          │  │  breadcrumb.html
    │      │          │  │  error.html
    │      │          │  │  fragments.html
    │      │          │  │  index.html
    │      │          │  │  login.html
    │      │          │  │  message.html
    │      │          │  │  navigation.html
    │      │          │  │
    │      │          │  ├─address_book
    │      │          │  │      addresses.html
    │      │          │  │      address_form.html
    │      │          │  │
    │      │          │  ├─cart
    │      │          │  │      quantity_control.html
    │      │          │  │      shopping_cart.html
    │      │          │  │
    │      │          │  ├─customer
    │      │          │  │      account_form.html
    │      │          │  │      forgot_password_form.html
    │      │          │  │      reset_password_form.html
    │      │          │  │
    │      │          │  ├─error
    │      │          │  │      403.html
    │      │          │  │      404.html
    │      │          │  │      500.html
    │      │          │  │
    │      │          │  ├─product
    │      │          │  │      images_carousel.html
    │      │          │  │      products_by_category.html
    │      │          │  │      product_detail.html
    │      │          │  │      product_fragment.html
    │      │          │  │      search_result.html
    │      │          │  │
    │      │          │  └─register
    │      │          │          register_form.html
    │      │          │          register_success.html
    │      │          │          verify_fail.html
    │      │          │          verify_success.html
    │      │          │
    │      │          ├─address_book
    │      │          │      addresses.html
    │      │          │      address_form.html
    │      │          │
    │      │          ├─cart
    │      │          │      quantity_control.html
    │      │          │      shopping_cart.html
    │      │          │
    │      │          ├─checkout
    │      │          │      checkout.html
    │      │          │      order_completed.html
    │      │          │
    │      │          ├─customer
    │      │          │      account_form.html
    │      │          │      forgot_password_form.html
    │      │          │      reset_password_form.html
    │      │          │
    │      │          ├─error
    │      │          │      403.html
    │      │          │      404.html
    │      │          │      500.html
    │      │          │
    │      │          ├─orders
    │      │          │      orders_customer.html
    │      │          │      order_details_modal.html
    │      │          │      order_status_fragment.html
    │      │          │      return_order_modal.html
    │      │          │
    │      │          ├─product
    │      │          │      images_carousel.html
    │      │          │      products_by_category.html
    │      │          │      product_detail.html
    │      │          │      product_fragment.html
    │      │          │      search_result.html
    │      │          │
    │      │          └─register
    │      │                  register_form.html
    │      │                  register_success.html
    │      │                  verify_fail.html
    │      │                  verify_success.html
    │      │
    │      └─test
    │          └─java
    │              └─com
    │                  └─dushop
    │                      │  DuShopFrontEndApplicationTests.java
    │                      │
    │                      ├─address
    │                      │      AddressRepositoryTests.java
    │                      │
    │                      ├─category
    │                      │      CategoryRepositoryTests.java
    │                      │      ProductRepositoryTests.java
    │                      │
    │                      ├─checkout
    │                      │      PayPalApiTests.java
    │                      │
    │                      ├─customer
    │                      │      CustomerRepositoryTests.java
    │                      │
    │                      ├─setting
    │                      │      SettingRepositoryTests.java
    │                      │
    │                      ├─shipping
    │                      │      ShippingRateRepositoryTests.java
    │                      │
    │                      └─shoppingcart
    │                              CartItemRepositoryTests.java
    │
    ├─product-images
    │  
    │
    ├─site-logo
    │      01.png
    │      default-user.png
    │      DuShopAdminBig.png
    │      DuShopAdminSmall.png
    │      image-thumbnail.png
    │
    └─src
        └─main
            └─resources
                    application.properties
