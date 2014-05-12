define([], function() {
    App.Model._FacturaModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : ''        },
        initialize: function() {
        },
        getDisplay: function(name) {
         return this.get(name);
        }
    });

    App.Model._FacturaList = Backbone.Collection.extend({
        model: App.Model._FacturaModel,
        initialize: function() {
        }

    });
    return App.Model._FacturaModel;
});