define([], function() {
    App.Model._FacturaMasterModel = Backbone.Model.extend({
     
    });

    App.Model._FacturaMasterList = Backbone.Collection.extend({
        model: App.Model._FacturaMasterModel,
        initialize: function() {
        }

    });
    return App.Model._FacturaMasterModel;
    
});