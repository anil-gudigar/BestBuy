package com.bestbuy.discovery.data.model


import com.bestbuy.stylekit.ui.toDoubleOrZero
import com.bestbuy.stylekit.ui.toStringOrEmpty
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("accessories")
    var accessories: List<String?>?,
    @SerializedName("accessoriesImage")
    var accessoriesImage: String?,
    @SerializedName("activationCharge")
    var activationCharge: String?,
    @SerializedName("active")
    var active: Boolean?,
    @SerializedName("activeUpdateDate")
    var activeUpdateDate: String?,
    @SerializedName("addToCartUrl")
    var addToCartUrl: String?,
    @SerializedName("affiliateAddToCartUrl")
    var affiliateAddToCartUrl: String?,
    @SerializedName("affiliateUrl")
    var affiliateUrl: String?,
    @SerializedName("albumLabel")
    var albumLabel: String?,
    @SerializedName("albumTitle")
    var albumTitle: String?,
    @SerializedName("alternateCategories")
    var alternateCategories: Any?,
    @SerializedName("alternateViewsImage")
    var alternateViewsImage: String?,
    @SerializedName("angleImage")
    var angleImage: String?,
    @SerializedName("artistId")
    var artistId: String?,
    @SerializedName("artistName")
    var artistName: String?,
    @SerializedName("aspectRatio")
    var aspectRatio: String?,
    @SerializedName("backViewImage")
    var backViewImage: String?,
    @SerializedName("bestSellingRank")
    var bestSellingRank: String?,
    @SerializedName("bundledIn")
    var bundledIn: List<String?>?,
    @SerializedName("buybackPlans")
    var buybackPlans: List<String?>?,
    @SerializedName("carrierModelNumber")
    var carrierModelNumber: String?,
    @SerializedName("carrierPlan")
    var carrierPlan: String?,
    @SerializedName("carrierPlans")
    var carrierPlans: List<String?>?,
    @SerializedName("carriers")
    var carriers: List<String?>?,
    @SerializedName("categoryPath")
    var categoryPath: List<CategoryPath?>?,
    @SerializedName("classId")
    var classId: Int?,
    @SerializedName("class")
    var classX: String?,
    @SerializedName("clearance")
    var clearance: Boolean?,
    @SerializedName("color")
    var color: String?,
    @SerializedName("condition")
    var condition: String?,
    @SerializedName("contracts")
    var contracts: List<String?>?,
    @SerializedName("crossSell")
    var crossSell: List<String?>?,
    @SerializedName("customerReviewAverage")
    var customerReviewAverage: Double?,
    @SerializedName("customerReviewCount")
    var customerReviewCount: Int?,
    @SerializedName("customerTopRated")
    var customerTopRated: Boolean?,
    @SerializedName("department")
    var department: String?,
    @SerializedName("departmentId")
    var departmentId: Int?,
    @SerializedName("depth")
    var depth: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("devices")
    var devices: List<String?>?,
    @SerializedName("digital")
    var digital: Boolean?,
    @SerializedName("dollarSavings")
    var dollarSavings: Double?,
    @SerializedName("earlyTerminationFees")
    var earlyTerminationFees: List<String?>?,
    @SerializedName("energyGuideImage")
    var energyGuideImage: String?,
    @SerializedName("esrbRating")
    var esrbRating: String?,
    @SerializedName("familyIndividualCode")
    var familyIndividualCode: String?,
    @SerializedName("format")
    var format: String?,
    @SerializedName("freeShipping")
    var freeShipping: Boolean?,
    @SerializedName("freeShippingEligible")
    var freeShippingEligible: Boolean?,
    @SerializedName("frequentlyPurchasedWith")
    var frequentlyPurchasedWith: List<String?>?,
    @SerializedName("friendsAndFamilyPickup")
    var friendsAndFamilyPickup: Boolean?,
    @SerializedName("fulfilledBy")
    var fulfilledBy: String?,
    @SerializedName("genre")
    var genre: String?,
    @SerializedName("height")
    var height: String?,
    @SerializedName("homeDelivery")
    var homeDelivery: Boolean?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("images")
    var images: List<Image?>?,
    @SerializedName("inStoreAvailability")
    var inStoreAvailability: Boolean?,
    @SerializedName("inStoreAvailabilityText")
    var inStoreAvailabilityText: String?,
    @SerializedName("inStoreAvailabilityUpdateDate")
    var inStoreAvailabilityUpdateDate: String?,
    @SerializedName("inStorePickup")
    var inStorePickup: Boolean?,
    @SerializedName("includedItemList")
    var includedItemList: List<IncludedItem?>?,
    @SerializedName("itemUpdateDate")
    var itemUpdateDate: String?,
    @SerializedName("largeFrontImage")
    var largeFrontImage: String?,
    @SerializedName("largeImage")
    var largeImage: String?,
    @SerializedName("leftViewImage")
    var leftViewImage: String?,
    @SerializedName("lengthInMinutes")
    var lengthInMinutes: String?,
    @SerializedName("linkShareAffiliateAddToCartUrl")
    var linkShareAffiliateAddToCartUrl: String?,
    @SerializedName("linkShareAffiliateUrl")
    var linkShareAffiliateUrl: String?,
    @SerializedName("listingId")
    var listingId: String?,
    @SerializedName("lists")
    var lists: List<String?>?,
    @SerializedName("longDescription")
    var longDescription: String?,
    @SerializedName("lowPriceGuarantee")
    var lowPriceGuarantee: Boolean?,
    @SerializedName("manufacturer")
    var manufacturer: String?,
    @SerializedName("marketplace")
    var marketplace: String?,
    @SerializedName("mediaCount")
    var mediaCount: String?,
    @SerializedName("mediumImage")
    var mediumImage: String?,
    @SerializedName("members")
    var members: List<String?>?,
    @SerializedName("minutePrice")
    var minutePrice: String?,
    @SerializedName("mobileUrl")
    var mobileUrl: String?,
    @SerializedName("modelNumber")
    var modelNumber: String?,
    @SerializedName("monoStereo")
    var monoStereo: String?,
    @SerializedName("monthlyRecurringCharge")
    var monthlyRecurringCharge: String?,
    @SerializedName("monthlyRecurringChargeGrandTotal")
    var monthlyRecurringChargeGrandTotal: String?,
    @SerializedName("mpaaRating")
    var mpaaRating: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("new")
    var new: Boolean?,
    @SerializedName("numberOfPlayers")
    var numberOfPlayers: String?,
    @SerializedName("onSale")
    var onSale: Boolean?,
    @SerializedName("onlineAvailability")
    var onlineAvailability: Boolean?,
    @SerializedName("onlineAvailabilityText")
    var onlineAvailabilityText: String?,
    @SerializedName("onlineAvailabilityUpdateDate")
    var onlineAvailabilityUpdateDate: String?,
    @SerializedName("orderable")
    var orderable: String?,
    @SerializedName("originalReleaseDate")
    var originalReleaseDate: String?,
    @SerializedName("outletCenter")
    var outletCenter: String?,
    @SerializedName("parentalAdvisory")
    var parentalAdvisory: String?,
    @SerializedName("percentSavings")
    var percentSavings: String?,
    @SerializedName("planCategory")
    var planCategory: String?,
    @SerializedName("planFeatures")
    var planFeatures: List<String?>?,
    @SerializedName("planPrice")
    var planPrice: String?,
    @SerializedName("planType")
    var planType: String?,
    @SerializedName("platform")
    var platform: String?,
    @SerializedName("plot")
    var plot: String?,
    @SerializedName("preowned")
    var preowned: Boolean?,
    @SerializedName("priceRestriction")
    var priceRestriction: String?,
    @SerializedName("priceUpdateDate")
    var priceUpdateDate: String?,
    @SerializedName("priceWithPlan")
    var priceWithPlan: List<String?>?,
    @SerializedName("productFamilies")
    var productFamilies: List<String?>?,
    @SerializedName("productId")
    var productId: String?,
    @SerializedName("productTemplate")
    var productTemplate: String?,
    @SerializedName("productVariations")
    var productVariations: Any?,
    @SerializedName("proposition65WarningMessage")
    var proposition65WarningMessage: String?,
    @SerializedName("proposition65WarningType")
    var proposition65WarningType: String?,
    @SerializedName("protectionPlanDetails")
    var protectionPlanDetails: List<String?>?,
    @SerializedName("protectionPlanHighPrice")
    var protectionPlanHighPrice: String?,
    @SerializedName("protectionPlanLowPrice")
    var protectionPlanLowPrice: String?,
    @SerializedName("protectionPlanTerm")
    var protectionPlanTerm: String?,
    @SerializedName("protectionPlanType")
    var protectionPlanType: String?,
    @SerializedName("protectionPlans")
    var protectionPlans: List<String?>?,
    @SerializedName("quantityLimit")
    var quantityLimit: Int?,
    @SerializedName("regularPrice")
    var regularPrice: Double?,
    @SerializedName("relatedProducts")
    var relatedProducts: List<String?>?,
    @SerializedName("releaseDate")
    var releaseDate: String?,
    @SerializedName("remoteControlImage")
    var remoteControlImage: String?,
    @SerializedName("requiredParts")
    var requiredParts: Any?,
    @SerializedName("rightViewImage")
    var rightViewImage: String?,
    @SerializedName("salePrice")
    var salePrice: Any?,
    @SerializedName("salesRankLongTerm")
    var salesRankLongTerm: String?,
    @SerializedName("salesRankMediumTerm")
    var salesRankMediumTerm: String?,
    @SerializedName("salesRankShortTerm")
    var salesRankShortTerm: String?,
    @SerializedName("score")
    var score: String?,
    @SerializedName("screenFormat")
    var screenFormat: String?,
    @SerializedName("secondaryMarket")
    var secondaryMarket: String?,
    @SerializedName("sellerId")
    var sellerId: String?,
    @SerializedName("shipping")
    var shipping: List<Shipping?>?,
    @SerializedName("shippingCost")
    var shippingCost: Any?,
    @SerializedName("shippingLevelsOfService")
    var shippingLevelsOfService: List<ShippingLevelsOfService?>?,
    @SerializedName("shippingRestrictions")
    var shippingRestrictions: String?,
    @SerializedName("shippingWeight")
    var shippingWeight: Double?,
    @SerializedName("shortDescription")
    var shortDescription: String?,
    @SerializedName("sku")
    var sku: Int?,
    @SerializedName("softwareAge")
    var softwareAge: String?,
    @SerializedName("softwareGrade")
    var softwareGrade: String?,
    @SerializedName("softwareNumberOfPlayers")
    var softwareNumberOfPlayers: String?,
    @SerializedName("source")
    var source: String?,
    @SerializedName("specialOrder")
    var specialOrder: Boolean?,
    @SerializedName("spin360Url")
    var spin360Url: String?,
    @SerializedName("startDate")
    var startDate: String?,
    @SerializedName("studio")
    var studio: String?,
    @SerializedName("studioLive")
    var studioLive: String?,
    @SerializedName("subclass")
    var subclass: String?,
    @SerializedName("subclassId")
    var subclassId: Int?,
    @SerializedName("techSupportPlans")
    var techSupportPlans: List<String?>?,
    @SerializedName("technologyCode")
    var technologyCode: String?,
    @SerializedName("theatricalReleaseDate")
    var theatricalReleaseDate: String?,
    @SerializedName("thumbnailImage")
    var thumbnailImage: String?,
    @SerializedName("topViewImage")
    var topViewImage: String?,
    @SerializedName("tradeInValue")
    var tradeInValue: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("upc")
    var upc: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("validFrom")
    var validFrom: String?,
    @SerializedName("validUntil")
    var validUntil: String?,
    @SerializedName("warrantyLabor")
    var warrantyLabor: String?,
    @SerializedName("warrantyParts")
    var warrantyParts: String?,
    @SerializedName("weight")
    var weight: String?,
    @SerializedName("width")
    var width: String?
){
    fun getSalesPrice():String{
        return salePrice.toStringOrEmpty()
    }
}