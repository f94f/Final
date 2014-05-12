define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/facturaModel', 'controller/facturaController'], function() {
    App.Component.FacturaComponent = App.Component._CRUDComponent.extend({
        name: 'factura',
        model: App.Model.FacturaModel,
        listModel: App.Model.FacturaList,
        controller : App.Controller.FacturaController
    });
    return App.Component.FacturaComponent;
});